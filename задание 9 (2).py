#вариант10 #2

m = int(input("введите кол-во столбцов: "))
n = int(input("введите кол-во строк: "))
d = []
for i in range(0, n):
    b = []
    for j in range(0, m):
        b.append(int(input(f"число №{j+1} строки №{i+1}: ")))
    d.append(b)
    print()

print("исходный массив:")
for i in range (0, n):
    for j in range(0, m):
        print(d[i][j], end=' ')
    print()

y = []
for i in range(m):  
    y.append([])
    for j in range(n):
        y[i].append(d[j][i])
d = [i[::-1] for i in y]
k = int(input("номер строки: "))
d.sort(key=lambda x: x[n - k])
y = []
for i in range(n):  
    y.append([])
    for j in range(m):
        y[i].append(d[j][i])
d = y[::-1]
for i in d:  
    print(*i)
