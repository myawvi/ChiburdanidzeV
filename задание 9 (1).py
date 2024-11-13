#вариант10 #1
n = int(input("введите кол-во строк: "))
m = int(input("введите кол-во столбцов: "))
a = []
for i in range(0, n):
    b = []
    for j in range(0, m):
        b.append(int(input(f"число №{j+1} строки №{i+1}: ")))
    
    a.append(b)
    print()

print("исходный массив:")

for i in a:  
    print(*i)

sorted_mas = []

for i in range(0, n):
    tmp = a[i]
    
    k = sorted(tmp)
    k2 = sorted(tmp, reverse=True)

    if tmp == k or tmp == k2:
        sorted_mas.append(tmp)

print("\nстроки, которые упорядочены:")
for i in sorted_mas:
    print(*i)
print()

max_num = -10000
for i in sorted_mas:
    for j in i:
        if j > max_num:
            max_num = j

print(f"максимальное число: {max_num}")
