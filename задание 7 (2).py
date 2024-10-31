#вариант10 #2

a = []

#a = [8, 10, 13, 21, 20, 9, 6, 28, 31, 5, 8, 12, 13, 14, 15]

for i in range(0, 15):
    a.append(int(input(f"число №{i+1}: ")))
a1 = a
print(a, end=' -- ')
for i in range(0, len(a1)):
    if a1[i] < 10:
        a1[i] = 0

    elif a1[i] > 20:
        a1[i] = 1
print(a1)
