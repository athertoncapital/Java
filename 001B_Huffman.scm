;; 001B_Huffman.scm
;;
;; William Chuang
;; Reference: SCIP example
;; Computer Science 245
;;
;; Notions: Codes such as ASCII and Huffman codes are known as fixed-length 
;; codes, because they represent each symbol in the message with the same number of bits.
;; It is sometimes advantageous to use variable-length codes, in which different symbols may
;; be represented by different numbers of bits. For example, Morse code does not use the same
;; number of dots and dashes for each letter of the alphabet.
;; In particular, E, the most frequent letter, is represented by a single dot.
;;

;; Decoding
(define (make-leaf symbol weight)
  (list 'leaf symbol weight))

(define (leaf? object)
  (eq? 'leaf (car object)))

(define (leaf-symbol leaf)
  (cadr leaf))

(define (leaf-weight leaf)
  (caddr leaf))

(define (make-node left right)
  (list left
	right
	(append (symbols left) (symbols right))
	(+ (weight left) (weight right))))

(define (left-branch node)
  (car node))
(define (right-branch node)
  (cadr node))

(define (symbols object)
  (if (leaf? object)
      (list (leaf-symbol object))
      (caddr object)))

(define (weight object)
  (if (leaf? object)
      (leaf-weight object)
      (cadddr object)))

(define (decode bits tree)
  (define (decode-1 bits current-branch)
    (if (null? bits)
	'()
	(let ((next-branch
	       (choose-branch (car bits) current-branch)))
	  (if (leaf? next-branch)
	      (cons (leaf-symbol next-branch)
		    (decode-1 (cdr bits) tree))
	      (decode-1 (cdr bits) next-branch)))))
  (decode-1 bits tree))

(define (choose-branch bit branch)
  (cond ((= bit 0) (left-branch branch))
	((= bit 1) (right-branch branch))
	(else (error "bad bit -- CHOOSE BRANCH" bit))))

(define (sort-pairs pair pair-list)
  (cond ((null? pair-list) (list pair))
	((< (weight pair) (weight (car pair-list))) (cons pair pair-list))

	(else (cons (car pair-list)
		    (sort-pairs pair (cdr pair-list))))))

(define (make-leaves pairs)
  (if (null? pairs)
      '()
      (let ((pair (car pairs)))

	(sort-pairs (make-leaf (car pair) ; symbol
			       (cadr pair)) ; weight
		    (make-leaves (cdr pairs))))))

(define sample-tree
  (make-node (make-leaf 'A 4)
	     (make-node
	      (make-leaf 'B 2)
	      (make-node (make-leaf 'D 1)
			 (make-leaf 'C 1)))))

;; ENCODING ;;
(define (encode message tree)
  (if (null? message)
      '()
      (append (encode-symbol (car message) tree)
	      (encode (cdr message) tree))))

;; iterate over list, checking for symbol
(define  (symbol-in-list? symbol test-list)
  (if (null? test-list)
      #f
      (if (eq? symbol (car test-list))
	  #t
	  (symbol-in-list? symbol (cdr test-list)))))

;; check a node for a symbol
(define (symbol-in-node symbol test-node)
  (if (null? test-node)
      #f
      (if (symbol-in-list symbol (cadddr test-node))
	  #t
	  #f)))

;; traverse tree
(define (search-tree symbol tree path)
  (if (leaf? tree)
      ;; is the symbol in the leaf?
      (if (eq? symbol (cadr tree))
	  path
	  '()
	  )

      (cond ((symbol-in-node symbol (car tree)) (search-tree symbol (car tree) (append path '(1))))
	    ((symbol-in-node symbol (cadr tree)) (search-tree symbol (car tree) (append path '(0)))))))

;; traverse tree until symbol is found
(define (encode-symbol symbol tree)
  (begin (display symbol))
  (search-tree symbol tree '()))

(define sample-tree
  (make-node (make-leaf 'A 4)
	     (make-node
	      (make-leaf 'B 2)
	      (make-node (make-leaf 'D 1)
			 (make-leaf 'C 1)))))

(define sample-message '(0 1 1 0 0 0 0 1 1 1 1 1 0))
(define message (encode sample-message sample-tree))
(encode message sample-tree)
