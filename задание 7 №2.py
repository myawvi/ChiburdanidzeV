#вариант10 #2

import random

arr, arr2=[], []
for i in range(15):
    arr.append(random.randrange(-10, 30))
    arr2.append(arr[i])
    if arr[i] < 10:
        arr2[i] = 0
        if arr[i] > 20:
            arr2[i] = 1
print("исходный:\n", arr,"\nпреобразованный:\n", arr2)

        
