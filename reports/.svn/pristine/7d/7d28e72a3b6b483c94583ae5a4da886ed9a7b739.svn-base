from math import factorial

from prettytable import PrettyTable


def lagrange(dots, x):
    result = 0
    n = len(dots)
    for i in range(n):
        nom, denom = 1, 1
        for j in range(n):
            if i == j:
                continue
            nom *= x - dots[j][0]
            denom *= dots[i][0] - dots[j][0]

        result += dots[i][1] * (nom / denom)

    return result

# TODO def lagrange_inaccuracy()


def gauss_t_first(t, n):
    tmp = t
    for i in range(1, n):
        tmp *= t + ((-1) ** i) * ((i + 1) // 2)
    return tmp

def gauss_t_second(t, n):
    tmp = t
    for i in range(1, n):
        if i == 1:
            tmp *= t + ((i + 1) // 2)
        else:
            tmp *= t + ((-1) ** i) * ((i + 1) // 2)
    return tmp


def gauss_first_formula(dots, x):  # x > a
    n = len(dots)

    y = finite_differences(dots)
    print(y)
    result = y[n // 2][0]  # 3//2 ?
    t = (x - dots[n // 2][0]) / (dots[1][0] - dots[0][0])  # t = (x - x_mid) / (x1 - x0)
    for i in range(1, n):
        result += gauss_t_first(t, i) * y[(n - i) // 2][i] / factorial(i)
        # print(y[(n - i) // 2][i])

    return round(result, 4)


def gauss_second_formula(dots, x):
    n = len(dots)

    y = finite_differences(dots)
    result = y[n // 2][0]  # 3//2 ?
    t = (x - dots[n // 2][0]) / (dots[1][0] - dots[0][0])  # t = (x - x_mid) / (x1 - x0)
    for i in range(1, n):
        result += gauss_t_second(t, i) * y[(n - i - 1) // 2][i] / factorial(i)
        # print(str(gauss_t_second(t, i)) + '*' + str(y[(n - i - 1) // 2][i] / factorial(i)))
    return round(result, 4)  # FIXME неправильно вычисляет начиная с некоторого члена

def finite_differences(dots):
    n = len(dots)
    y = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        y[i][0] = dots[i][1]
    for i in range(1, n):
        for j in range(n - i):
            y[j][i] = round(y[j + 1][i - 1] - y[j][i - 1], 3)
    return y

# def get_finite_differences_table(dots):  # FIXME не считается последняя дельта
    # diff_table = PrettyTable()
    #
    # index = []  # formation of the first column
    # for i in range(len(dots)):
    #     index.append(i)
    # diff_table.add_column("o", index)
    #
    # x = []  # formation of the second column
    # for i in range(len(dots)):
    #     x.append(dots[i][0])
    # diff_table.add_column("x", x)
    #
    # y = []  # formation of the third column
    # for i in range(len(dots)):
    #     y.append(dots[i][1])
    # diff_table.add_column("y", y)
    #
    # last_delta = []
    # count_of_deltas = len(dots) - 1
    # for i in range(count_of_deltas):
    #     column_name = "delta^" + str(i+1) + "y_i" if i != 0 else "delta y_i"
    #     if i == 0:
    #         current_delta = []
    #         for j in range(len(dots)):
    #             current_delta.append(dots[j][1])
    #         diff_table.add_column(column_name, current_delta)
    #         last_delta = current_delta
    #     else:
    #         current_delta = []
    #         for j in range(count_of_deltas - i + 1):
    #             current_delta.append(round(last_delta[j + 1] - last_delta[j], 3))
    #         while len(current_delta) < 7:
    #             current_delta.append('')  # FIXME
    #         diff_table.add_column(column_name, current_delta)
    #         last_delta = current_delta
    #
    # return diff_table
