#вариант10 #1
def nums(n, a, b, c):
    kol = 0
    for i in range(100, n):
        tmp = str(i)

        if (str(a) in tmp) and (str(b) in tmp) and (str(c) in tmp):
            kol += 1

    return kol

n = int(input("введите конечную точку отрезка (210 < N 231): "))


if n < 210 or n > 231:
    print("ошибка ввода данных")
else:
    print("введите цифры, из которых состоят числа: ")
    a = int(input("A = "))
    b = int(input("B = "))
    c = int(input("C = "))
    if (a < 0 or a > 9) or (b < 0 or b > 9) or (c < 0 or c > 9):
        print("ошибка ввода данных")
    else:
        if nums(n, a, b, c) == 0:
            print("ни одно число не состоит только из этих цифр")
        elif nums(n, a, b, c) > 0:
            print(f"кол-во чисел, состоящих из этих цифр: {nums(n, a, b, c)}")
        
