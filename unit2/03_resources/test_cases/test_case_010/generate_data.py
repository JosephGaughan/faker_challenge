import os
import shutil
from faker import Faker

# Set up
faker = Faker("en_GB")
target_dir = os.getcwd()
originals_dir = os.path.join(target_dir, "originals")
allowlist_path = os.path.join(target_dir, "allowlist")

# Reset originals folder
if os.path.exists(originals_dir):
    shutil.rmtree(originals_dir)
os.makedirs(originals_dir)

# Reset allowlist file
if os.path.exists(allowlist_path):
    os.remove(allowlist_path)

# Generate documents and populate allowlist
surnames_used = []

for _ in range(100):
    name = faker.name()
    address_lines = [
        name,
        faker.street_address(),
        faker.city(),
        faker.postcode()
    ]
    surname = name.split()[-1]
    filename = os.path.join(originals_dir, surname)

    # Write to file
    with open(filename, "w") as f:
        f.write("\n".join(address_lines))

    surnames_used.append(surname)

# Write surnames to allowlist
with open(allowlist_path, "w") as f:
    for surname in surnames_used:
        f.write(surname + "\n")

print(f"Generated 100 UK addresses in '{originals_dir}' and updated 'allowlist'")
