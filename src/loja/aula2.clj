(ns loja.aula2)

;["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]


(defn conta
  [total-ate-agora elementos]
  (if (seq elementos)
    (recur (inc total-ate-agora) (next elementos))
    total-ate-agora))

(println (conta 0 ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))

(println (conta 0 []))


;função com variações
(defn minha-funcao
  ([parametro1] (println "p1" parametro1))
  ([parametro1 parametro2] (println "p2" parametro1 parametro2)))

(minha-funcao 1)
(minha-funcao 1 2)



; conta com váriações
(defn conta

  ([elementos]
   (conta 0 elementos))

  ([total-ate-agora elementos]
   (if (seq elementos)
     (recur (inc total-ate-agora) (next elementos))
     total-ate-agora)))

(println (conta 0 ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))

(println (conta 0 []))


(println (conta ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))

(println (conta []))




; conta com loop
(defn conta
  [elementos]
  ;(println "executando antes do recur")
  (loop [total-ate-agora 0
         elementos-restantes elementos]
    (if (seq elementos-restantes)
      (recur (inc total-ate-agora) (next elementos-restantes))
      total-ate-agora)))

(println (conta ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))

(println (conta []))