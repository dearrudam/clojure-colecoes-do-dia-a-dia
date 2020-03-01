(ns loja.aula3
  (:require [loja.db :as l.db]))

(println (l.db/todos-os-pedidos))

(println (group-by :usuario (l.db/todos-os-pedidos)))

(defn minha-funcao-de-agrupamento
  [elemento]
  (println "elemento" elemento)
  (:usuario elemento))


(println (group-by minha-funcao-de-agrupamento (l.db/todos-os-pedidos)))

;  { 15 [x,y,c]
;     1 [x]
;    10 [x]
;    20 [x,z] }

(println (count (vals (group-by :usuario (l.db/todos-os-pedidos)))))
(println (map count (vals (group-by :usuario (l.db/todos-os-pedidos)))))

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     vals
     (map count)
     println)

(defn conta-total-por-usuario
  [[usuairio pedidos]]
  [usuairio (count pedidos)])

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map conta-total-por-usuario)
     println)


(defn conta-total-por-usuario
               [[usuairio pedidos]]
               {:usuario-id usuairio,
                :total-de-pedidos (count pedidos)})

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map conta-total-por-usuario)
     println)






(println "\n\nPEDIDOS")

(defn total-do-item
  [[_ detalhes]]
  (* (get detalhes :quantidade 0) (get detalhes :preco-unitario 0)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       (map total-do-item)
       (reduce +)))

(defn total-de-pedidos
  [pedidos]
  (->> pedidos
       (map :items)
       (map total-do-pedido)
       (reduce +)))

(defn quantia-de-pedidos-e-gasto-total-por-usuario
  [[usuairio pedidos]]
  {:usuario-id usuairio,
   :total-de-pedidos (count pedidos),
   :preco-total (total-de-pedidos pedidos)})

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map quantia-de-pedidos-e-gasto-total-por-usuario)
     println)