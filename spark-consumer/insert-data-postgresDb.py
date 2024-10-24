import time
import csv
import psycopg2
from psycopg2 import sql

# Define PostgreSQL connection details
conn_details = {
    'dbname': 'postgres',
    'user': 'postgres',
    'password': 'postgres',
    'host': 'postgres',
    'port': '5432'
}

# Establish a connection to the PostgreSQL database
def connect_to_db():
    try:
        conn = psycopg2.connect(**conn_details)
        return conn
    except Exception as e:
        print(f"Error connecting to the database: {e}")
        return None

# Function to create table if it doesn't exist
def create_table(conn):
    create_table_query = '''
    CREATE TABLE IF NOT EXISTS smartphones (
        id SERIAL PRIMARY KEY,
        brand VARCHAR(255),
        screen_size FLOAT,
        ram FLOAT,
        rom FLOAT,
        sim_type VARCHAR(255),
        battery FLOAT,
        price FLOAT
    );
    '''
    try:
        with conn.cursor() as cur:
            cur.execute(create_table_query)
            conn.commit()
    except Exception as e:
        print(f"Error creating table: {e}")

# Function to insert a row into the database
def insert_data(conn, row):
    insert_query = '''
    INSERT INTO smartphones (id, brand, screen_size, ram, rom, sim_type, battery, price)
    VALUES (%s, %s, %s, %s, %s, %s, %s, %s)
    ON CONFLICT (id) DO NOTHING;
    '''
    try:
        with conn.cursor() as cur:
            cur.execute(insert_query, row)
            conn.commit()
    except Exception as e:
        print(f"Error inserting data: {e}")

# Function to read data from CSV file
def read_csv(file_path):
    with open(file_path, mode='r') as file:
        csv_reader = csv.reader(file)
        next(csv_reader)  # Skip header row
        for row in csv_reader:
            yield row

def main():
    csv_file_path = 'data.csv'  # Path to your CSV file

    # Connect to the database
    conn = connect_to_db()
    if conn is None:
        print("Failed to connect to the database.")
        return

    # Create the table if it doesn't exist
    create_table(conn)

    # Read data from CSV and insert into DB every 5 seconds
    for row in read_csv(csv_file_path):
        print(f"Inserting row: {row}")
        insert_data(conn, row)
        time.sleep(5)  # Wait for 5 seconds before inserting the next row

    # Close the database connection
    conn.close()

if __name__ == '__main__':
    main()
