def words(s):
    a = s.split()
    a.reverse()
    tmp = ''
    for i in a:
        tmp += i + ' '
    return(tmp)

s = input("Введите строку: ")
print(words(s))
