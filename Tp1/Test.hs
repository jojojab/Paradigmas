import Control.Exception
import System.IO.Unsafe


import Point
import City
import Quality
import Link
import Tunel
import Region

testF :: Show a => a -> Bool
testF action = unsafePerformIO $ do
    result <- tryJust isException (evaluate action)
    return $ case result of
        Left _ -> True
        Right _ -> False
    where
        isException :: SomeException -> Maybe ()
        isException _ = Just ()

result :: Int -> Int
result x | x > 5 = 4
         | otherwise = error "hey"

-- ahora pueden evaluar
tPoint = [ difP1P2 == sqrt(18),
           difP1P3 == sqrt(162), 
           difP2P3 == sqrt(72) ]

tCity = [ nameC1 == "BsAs",
          nameC2 == "Tokyo",
          nameC3 == "New York",
          disC1C2 == sqrt(18),
          disC1C3 == sqrt(162),
          disC2C3 == sqrt(72) ]

tQuality = [ capq1 == 10,
             capq2 == 20,
             capq3 == 30,
             delq1 == 3,
             delq2 == 5,
             delq3 == 10 ]

tLink = [ conC1L1 == True,
          conC2L1 == True,
          conC3L1 == False,
          conC2L2 == True,
          conC3L2 == True,
          conC1L2 == False,
          c1c2L1 == True,
          c2c1L1 == True,
          c3L1 == False,
          capL1 == 10,
          capL2 == 20,
          capL3 == 30,
          delL1 == sqrt(18) * 3,
          delL2 == sqrt(72) * 5,
          delL3 == sqrt(162) * 10 ]

tTunel = [ conC1C3T1 == True,
           conC3C1T1 == True,
           conC2C3T2 == True,
           conC1C3T2 == False,
           usesL1T1 == True,
           usesL2T2 == False,
           usesL3T3 == True,
           delT1 == delL1 + delL2,
           delT2 == delL1 + delL3,
           delT3 == delL3 + delL2 ]

tRegion = [ conR7C1C2 == True,
            conR7C2C3 == False,
            conR9C1C2 == True,
            conR9C1C3 == True,
            linkedR5C1C2 == False,
            linkedR6C1C2 == False,
            linkedR6C1C3 == True,
            linkedR6C2C3 == True,
            delayR7C1C2 == delL3 + delL2,
            delayR9C1C2 == delL3 + delL2,
            delayR9C1C3 == delL1 + delL2,
            availableCapacityForR7C1C3 == 29,
            availableCapacityForR9C1C2 == 9,
            availableCapacityForR9C1C3 == 29,
            availableCapacityForR9C2C3 == 18 ]

-- modulo Point

p1 = newP 1 1
p2 = newP 4 4
p3 = newP 10 10
difP1P2 = difP p1 p2
difP1P3 = difP p1 p3
difP2P3 = difP p2 p3

-- modulo City

c1 = newC "BsAs" p1
c2 = newC "Tokyo" p2
c3 = newC "New York" p3

nameC1 = nameC c1
nameC2 = nameC c2
nameC3 = nameC c3

disC1C2 = distanceC c1 c2
disC1C3 = distanceC c1 c3
disC2C3 = distanceC c2 c3

-- modulo Quality

q1 = newQ "low" 10 3
q2 = newQ "medium" 20 5
q3 = newQ "high" 30 10

capq1 = capacityQ q1
capq2 = capacityQ q2
capq3 = capacityQ q3

delq1 = delayQ q1
delq2 = delayQ q2
delq3 = delayQ q3

-- modulo Link

l1 = newL c1 c2 q1
l2 = newL c2 c3 q2
l3 = newL c3 c1 q3

conC1L1 = connectsL c1 l1
conC2L1 = connectsL c2 l1
conC3L1 = connectsL c3 l1
conC2L2 = connectsL c2 l2
conC3L2 = connectsL c3 l2
conC1L2 = connectsL c1 l2

c1c2L1 = linksL c1 c2 l1
c2c1L1 = linksL c2 c1 l1
c3L1 = linksL c1 c3 l1

capL1 = capacityL l1
capL2 = capacityL l2
capL3 = capacityL l3

delL1 = delayL l1
delL2 = delayL l2
delL3 = delayL l3

-- modulo Tunel

t1 = newT [l1,l2]
t2 = newT [l3,l1]
t3 = newT [l2,l3]

conC1C3T1 = connectsT c1 c3 t1
conC3C1T1 = connectsT c1 c3 t1
conC2C3T2 = connectsT c2 c3 t2
conC1C3T2 = connectsT c1 c3 t2

usesL1T1 = usesT l1 t1
usesL2T2 = usesT l2 t2
usesL3T3 = usesT l3 t3

delT1 = delayT t1
delT2 = delayT t2
delT3 = delayT t3

-- modulo Region

reg1 = newR

reg2 = foundR reg1 c1
reg3 = foundR reg2 c2 
reg4 = foundR reg3 c3

linkR2C1C2 = linkR reg2 c1 c2 q1
linkR3C2C3 = linkR reg3 c2 c3 q1
linkR3C1C2 = linkR reg3 c1 c2 q2
reg5 = linkR reg4 c3 c1 q3
reg6 = linkR reg5 c2 c3 q2


tunelR1 = tunelR reg1 [c1,c2,c3]
tunelR2 = tunelR linkR3C2C3 [c1,c2,c3]
tunelR3 = tunelR linkR3C1C2 [c1,c2,c3]
reg7 = tunelR reg6 [c1,c3,c2]
tunelR5 = tunelR reg6 [c1,c2,c3]

reg8 = linkR reg7 c1 c2 q1
reg9 = tunelR reg8 [c1,c2,c3]

conR7C1C2 = connectedR reg7 c1 c2
conR7C2C3 = connectedR reg7 c2 c3
conR9C1C2 = connectedR reg9 c1 c2
conR9C1C3 = connectedR reg9 c1 c3

linkedR5C1C2 = linkedR reg5 c1 c2
linkedR6C1C2 = linkedR reg6 c1 c2
linkedR6C1C3 = linkedR reg6 c1 c3
linkedR6C2C3 = linkedR reg6 c2 c3

delayR7C1C2 = delayR reg7 c1 c2
delayR7C1C3 = delayR reg7 c1 c3
delayR9C1C2 = delayR reg9 c1 c2
delayR9C1C3 = delayR reg9 c1 c3

availableCapacityForR7C1C2 = availableCapacityForR reg7 c1 c2
availableCapacityForR7C1C3 = availableCapacityForR reg7 c1 c3
availableCapacityForR9C1C2 = availableCapacityForR reg9 c1 c2
availableCapacityForR9C1C3 = availableCapacityForR reg9 c1 c3
availableCapacityForR9C2C3 = availableCapacityForR reg9 c2 c3
