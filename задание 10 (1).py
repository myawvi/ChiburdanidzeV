# 1

with open('10-1_vvod.txt', 'r') as f:
    a = []
    for i in f:
        tmp = i.split()
        for j in range(0,len(tmp)):
            tmp[j] = int(tmp[j])
        a.append(tmp)
    print(a)


with open('10-1_vivod.txt', 'w') as f:
    sorted_mas = []
    for i in range(0, len(a)):
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
    f.write(f"{max_num}")

