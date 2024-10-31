#вариант10 #1

n = int(input("кол-во элементов: "))
a = []
for i in range(0, n):
    a.append(int(input(f"число №{i+1}: ")))

print("\nисходный массив: ", a)

nums = dict()
kol = 0
for i in a:
    nums[i] = a.count(i)
    if a.count(i) > 1:
        kol +=1

if kol > 0:
    print("повторяющиеся числа: ")
    for key, value in nums.items():
        if value > 1:
            print(f"{key}: {value}")

else:
    print("повторяющихся чисел нет")

