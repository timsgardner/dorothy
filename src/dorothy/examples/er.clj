(ns dorothy.examples.er
  (:use dorothy.core))

(defn -main [] 
  (-> 
    (graph :ER [
      {:rankdir :LR}

      [:node {:shape :box}]
      :course :institute :student

      [:node {:shape :ellipse}]

      (subgraph [
        [:node {:label "name"}] 
        :name0 :name1 :name2])

      :code :grade :number

      [:node {:shape :diamond,:style :filled,:color :lightgrey}] 
      "C-I" "S-C" "S-I"

      ; Edges
      [:name0     :> :course]
      [:code      :> :course]
      [:course    :> "C-I"      {:label "n",:len 1.00}]
      ["C-I"      :> :institute {:label "1",:len 1.00}]
      [:institute :> :name1]
      [:institute :> "S-I"      {:label "1",:len 1.00}]
      ["S-I"      :> :student   {:label "n",:len 1.00}]
      [:student   :> :grade]
      [:student   :> :name2]
      [:student   :> :number]
      [:student   :> "S-C"      {:label "m",:len 1.00}]
      ["S-C"      :> :course    {:label "n",:len 1.00}]

      {:label  "\n\nEntity Relation Diagram\ndrawn by NEATO"
       :fontsize 20}
      ])
    dot
    (show {:layout :neato}))) 

