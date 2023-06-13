def get_table_from_file(filename):
    table = []
    with open(filename) as file:  # FIXME divide
        for line in file:
            values = line.split(" ")
            table.append(values)

    return tuple(table)


def get_table_from_keyboard():
    print('Введите количество узлов интерполяции: ')
    n = int(input())

    table = []
    print('Вводите пары x y: ')
    for i in range(n):
        xypair = input().split(" ")
        table.append(xypair)

    return table
