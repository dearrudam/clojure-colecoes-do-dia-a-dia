(ns loja.aula5
  (:require [loja.db :as l.db]
            [loja.logic :as l.logic]))

(defn gastou-bastante? [info-usuario]
  (println "gastou-bastante?" (:usuario-id info-usuario))
  (> (:preco-total info-usuario) 500))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "keep" (keep gastou-bastante? resumo))
  (println "filter" (filter gastou-bastante? resumo)))


(println "trying to understand both functions: keep and filter")

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "keep" (keep gastou-bastante? resumo)))

(println "\nIsolating them...")

(println (range 10))
(println (take 2 (range 10000000000000)))                   ;looks like range function returns a function that is able to produce the requested elements
; the sequence is not EAGER!
(let [sequencia (range 1000000000)]
  (println (take 2 sequencia))
  (println (take 2 sequencia)))                             ;immutability, sequence is the same
; it's being a LAZY sequence !!!


; let's test the map function regarding to LAZY or EAGER consuming

(defn filter1 [x]
  (println "filter1" x)
  x)

(println (map filter1 (range 10)))

(defn filter2 [x]
  (println "filter2" x)
  x)

(println (map filter2 (map filter1 (range 10))))

(->> (range 10)
     (map filter1)
     (map filter2)
     println)



; map works with CHUNKS with 32 elements
(->> (range 50)
     (map filter1)
     (map filter2)
     println)


; mapv function converts the input to a vector, changing its loaging process to be EAGER
(->> (range 50)
     (mapv filter1)
     (mapv filter2)
     println)


(->> [0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 0 1 2 3 4 5 6 7 8 9 0]
     (map filter1)
     (map filter2)
     println)


; linked list was totally LAZY in this scenario
(->> '(0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 0 1 2 3 4 5 6 7 8 9 0)
     (map filter1)
     (map filter2)
     println)

