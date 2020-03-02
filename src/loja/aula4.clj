(ns loja.aula4
  (:require [loja.db :as l.db]
            [loja.logic :as l.logic]))

(println (l.db/todos-os-pedidos))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "Resumo" resumo)
  (println "Ordenado" (sort-by :preco-total resumo))
  (println "Ornedado ao contrário" (reverse (sort-by :preco-total resumo)))
  (println "Ordenado por usuário" (sort-by :usuario-id resumo))

  ; update-in, assoc-in
  (println (get-in pedidos [0 :items :mochila :quantidade])))


(defn resumo-por-usuario-ordenado
  [pedidos]
  (->> pedidos
       l.logic/resumo-por-usuario
       (sort-by :preco-total)
       reverse))


(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "Resumo" resumo)
  (println "Primeiro" (first resumo))
  (println "Segundo" (second resumo))
  (println "Resto" (rest resumo))
  (println "Total" (count resumo))
  (println "Class" (class resumo))
  (println "nth 1" (nth resumo 1))
  (println "get 1" (get resumo 1))
  (println "take" (take 2 resumo)))

(defn top-2 [resumo]
  (take 2 resumo))


(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "Resumo" resumo)
  (println "Top-2" (top-2 resumo)))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "> 500 filter" (filter #(> (:preco-total %) 500) resumo))
  ; using THREAD LAST declaration
  (println "> 500 filter empty not using last treading declaration=>"
           (->> (filter #(> (:preco-total %) 500) resumo)
                empty?
                not))
  ; always take a look in the clojure documentation in order to learn
  ; new functions because it's possible to there's some function that
  ; its results are pretty similar to results from a composition of
  ; functions that we're trying to use.
  ; For example, the "some" function that returns a response pretty
  ; similar to the composition of functions that we're using here.
  (println "> 500 filter empty not =>" (not (empty? (filter #(> (:preco-total %) 500) resumo))))
  (println "> 500 some =>" (some #(> (:preco-total %) 500) resumo)))
