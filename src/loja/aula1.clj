(ns loja.aula1)
; vetor
; ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]

; Mapa - Dicionário
; {"nome1" 12, "sdfsfsdf" 11,"wewekwfe" 12}

; Lista ligada
; '(1 2 3 4 5)

; Conjunto (set)
; #{}


; map
; reduce
; filter


; (map println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])

;; first retorna o primeiro elemento de uma sequencia
;(println (first ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
;; rest retorna o restante da sequencia exceto o primeiro elemento
;(println (rest ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
;; rest retorna uma sequencia vazia em caso de que a sequencia fornecida esteja vazia
;(println (rest []))

;; next retorna o restante da sequencia exceto o primeiro elemento
;(println (next ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
;; next retorna nil (ou nulo) em caso de que a sequencia fornecida esteja vazia
;(println (next []))

;; seq transforma num vetor em uma sequencia
;(println (seq [1 2 3]))
;; seq retorna nil em caso a sequencia ou vetor esteja vazia
;(println (seq []))


(println "\n\n\n\nMEU MAPA com parada com false\n")

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if primeiro
      (do
        (println primeiro)
        (meu-mapa funcao (next sequencia))))))

(println "\nmeu-mapa com " ["daniela" false "carlos" "paulo" "lucia" "ana"])
(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])
(println "\nmeu-mapa com " ["daniela" false "carlos" "paulo" "lucia" "ana"])
(meu-mapa println ["daniela" false "carlos" "paulo" "lucia" "ana"])
(println "\nmeu-mapa com " [])
(meu-mapa println [])
(println "\nmeu-mapa com " nil)
(meu-mapa println nil)


(println "\n\n\n\nMEU MAPA com parada com nil\n")

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (println primeiro)
        (meu-mapa funcao (next sequencia))))))

(println "\nmeu-mapa com " ["daniela" false "carlos" "paulo" "lucia" "ana"])
(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])
(println "\nmeu-mapa com " ["daniela" false "carlos" "paulo" "lucia" "ana"])
(meu-mapa println ["daniela" false "carlos" "paulo" "lucia" "ana"])
(println "\nmeu-mapa com " [])
(meu-mapa println [])
(println "\nmeu-mapa com " nil)
(meu-mapa println nil)


;(println "\n\n\n\nMEU MAPA testando com sequancias grandes\n")
;
;;Syntax error (StackOverflowError) compiling at (aula1.clj:82:1).
;(meu-mapa println (range 10000))


(println "\n\n\n\nMEU MAPA com parada com TAIL RECURSIONn")

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (println primeiro)
        (recur funcao (next sequencia))))))

(println "\nmeu-mapa com " ["daniela" false "carlos" "paulo" "lucia" "ana"])
(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])
(println "\nmeu-mapa com " ["daniela" false "carlos" "paulo" "lucia" "ana"])
(meu-mapa println ["daniela" false "carlos" "paulo" "lucia" "ana"])
(println "\nmeu-mapa com " [])
(meu-mapa println [])
(println "\nmeu-mapa com " nil)
(meu-mapa println nil)


(println "\n\n\n\nMEU MAPA testando com sequancias grandes\n")
(meu-mapa println (range 10000))


