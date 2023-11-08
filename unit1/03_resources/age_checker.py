import datetime

def is_old_enough(birth_y, birth_m, birth_d, age_check):
    return (datetime.date(2023, 1, 5) - datetime.timedelta(days=365.25)*age_check) >= datetime.date(birth_y, birth_m, birth_d)