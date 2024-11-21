# 2

n = 0
m = 0
d = []
with open("10-2_vvod.txt", "r") as f:
    for i in f:
        n+=1
        m = 0
        tmp = i.split()
        for j in range(0,len(tmp)):
            m += 1
            tmp[j] = int(tmp[j])
        d.append(tmp)
    print("исходный массив:")
    for i in d:
        print(i)
    print(n, m)
    
with open("10-2_vivod.txt", "w") as f:
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
    for i in d:
        for j in i:
            f.write(str(j)+" ")
        f.write("\n")
    
    
