module Quality ( Quality, newQ, capacityQ, delayQ )
   where

data Quality = Qua String Int Float deriving (Eq, Show)

newQ :: String -> Int -> Float -> Quality
capacityQ :: Quality -> Int -- cuantos túneles puede tolerar esta conexión
delayQ :: Quality -> Float  -- la demora por unidad de distancia que sucede en las conexiones de este canal

newQ name tol delay = Qua name tol delay
capacityQ (Qua name tol delay) = tol
delayQ (Qua name tol delay) = delay

qual1 = Qua "pepe" 10 3
capQ1 = capacityQ qual1
delQ1 = delayQ qual1