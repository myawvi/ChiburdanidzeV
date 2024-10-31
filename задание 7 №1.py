#вариант10 #1

from random import randint
N = 10
arr = [randint(1, 35) for i in range(N)]
print(arr)

for i in range(N-1):
    for j in range(i+1, N):
        if arr[i] == arr[j]:
            print("есть повторяющиеся числа")
            quit()
            print("повторяющиеся числа отсутствуют")
