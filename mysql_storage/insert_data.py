import mysql.connector
from notification_service.send_notification import send_email
import threading

processed_record_count = 0

def get_mysql_connection():
    # Update these connection details as per your MySQL setup
    conn = mysql.connector.connect(
        host='localhost',
        user='your_username',
        password='your_password',
        database='smartphones'
    )
    return conn

def update_mysql_with_kpis(df, insert_function):
    conn = get_mysql_connection()
    cursor = conn.cursor()
    try:
        # Insert or update data in MySQL
        insert_function(df, cursor)
        # Commit the transaction
        conn.commit()
    except Exception as e:
        print(f"Error: {str(e)}")
        conn.rollback()
    finally:
        cursor.close()
        conn.close()





############ 0. statistics_summary ##############
def insert_statistics_summary(df, cursor):
    pandas_df = df.toPandas()
    pandas_df = pandas_df.dropna()

    delete_query = "delete from statistics_summary "
    cursor.execute(delete_query)

    for index, row in pandas_df.iterrows():


        # Prepare the SQL query
        insert_query = """
        REPLACE INTO statistics_summary 
        (total_phones, max_price, max_screen_size, max_ram, max_rom, max_battery, updated_at) 
        VALUES (%s, %s, %s, %s, %s, %s, NOW());
        """

        # Extract values from the row
        values = (
            row['total_phones'],
            row['max_price'],
            row['max_screen_size'],
            row['max_ram'],
            row['max_rom'],
            row['max_battery']
        )

        # Execute the insert query
        cursor.execute(insert_query, values)

    print("Data updated successfully -- Table --  statistics summary !")


def insert_data_mysql_statistics_summary(batch_df, epoch_id):
    global processed_record_count


    # Establish the connection to the MySQL database
    conn = mysql.connector.connect(
        host='localhost',
        user='root',
        password='aymane2002',
        database='smartphones'
    )
    cursor = conn.cursor()

    # Pass the DataFrame to your function for processing and insertion
    update_mysql_with_kpis(batch_df, insert_statistics_summary)

    # Increment the processed records count based on the number of rows in the batch
    processed_record_count += 1
    send_batch_email_notification()

    # Commit and close the connection
    conn.commit()
    cursor.close()
    conn.close()

    print(f"Batch {epoch_id} processed and inserted into MySQL.")

####### 1. phones_per_brand #############
def insert_phones_per_brand(df, cursor):
    pandas_df = df.toPandas()
    pandas_df = pandas_df.dropna()
    delete_query = "delete from phones_per_brand "
    cursor.execute(delete_query)

    for index, row in pandas_df.iterrows():
        # Prepare the SQL query
        insert_query = """
        REPLACE INTO phones_per_brand (brand, total_phones, updated_at) 
        VALUES (%s, %s, NOW());
        """

        values = (
            row['brand'],
            row['total_phones']
        )

        cursor.execute(insert_query, values)

    print("Data updated successfully -- Table --  phones per brand  !")




def insert_data_mysql_phones_per_brand(batch_df, epoch_id):
    # Establish the connection to the MySQL database
    conn = mysql.connector.connect(
        host='localhost',
        user='root',
        password='aymane2002',
        database='smartphones'
    )
    cursor = conn.cursor()

    # Pass the DataFrame to your function for processing and insertion
    update_mysql_with_kpis(batch_df, insert_phones_per_brand)

    # Commit and close the connection
    conn.commit()
    cursor.close()
    conn.close()

    print(f"Batch {epoch_id} processed and inserted into MySQL.")


########## 2. phones_per_sim_type ###########
def insert_phones_per_sim_type(df, cursor):
    pandas_df = df.toPandas()
    pandas_df = pandas_df.dropna()
    delete_query = "delete from phones_per_sim_type"
    cursor.execute(delete_query)


    for index, row in pandas_df.iterrows():
        # Prepare the SQL query
        insert_query = """
        REPLACE INTO phones_per_sim_type (sim_type, total_phones, updated_at) 
        VALUES (%s, %s, NOW());
        """

        values = (
            row['sim_type'],
            row['total_phones']
        )

        cursor.execute(insert_query, values)

    print("Data updated successfully -- Table --  phones per sim type !")




def insert_data_mysql_phones_per_sim_type(batch_df, epoch_id):
    # Establish the connection to the MySQL database
    conn = mysql.connector.connect(
        host='localhost',
        user='root',
        password='aymane2002',
        database='smartphones'
    )
    cursor = conn.cursor()

    # Pass the DataFrame to your function for processing and insertion
    update_mysql_with_kpis(batch_df, insert_phones_per_sim_type)

    # Commit and close the connection
    conn.commit()
    cursor.close()
    conn.close()

    print(f"Batch {epoch_id} processed and inserted into MySQL.")





###### 3. max_price_per_brand #############
def insert_max_price_per_brand(df, cursor):
    pandas_df = df.toPandas()
    pandas_df = pandas_df.dropna()
    delete_query = "delete from max_price_per_brand"
    cursor.execute(delete_query)

    for index, row in pandas_df.iterrows():
        # Prepare the SQL query
        insert_query = """
           REPLACE INTO max_price_per_brand (brand, max_price, updated_at) 
           VALUES (%s, %s, NOW());
           """

        values = (
            row['brand'],
            row['max_price']
        )

        cursor.execute(insert_query, values)

    print("Data updated successfully -- Table --  max price per brand !")


def insert_data_mysql_max_price_per_brand(batch_df, epoch_id):
    # Establish the connection to the MySQL database
    conn = mysql.connector.connect(
        host='localhost',
        user='root',
        password='aymane2002',
        database='smartphones'
    )
    cursor = conn.cursor()

    # Pass the DataFrame to your function for processing and insertion
    update_mysql_with_kpis(batch_df, insert_max_price_per_brand)

    # Commit and close the connection
    conn.commit()
    cursor.close()
    conn.close()

    print(f"Batch {epoch_id} processed and inserted into MySQL.")





##### 4. max_price_per_sim_type

def insert_max_price_per_sim_type(df, cursor):
    pandas_df = df.toPandas()
    pandas_df = pandas_df.dropna()
    delete_query = "delete from max_price_per_sim_type"
    cursor.execute(delete_query)

    for index, row in pandas_df.iterrows():
        # Prepare the SQL query
        insert_query = """
           REPLACE INTO max_price_per_sim_type (sim_type, max_price, updated_at) 
           VALUES (%s, %s, NOW());
           """

        values = (
            row['sim_type'],
            row['max_price']
        )

        cursor.execute(insert_query, values)

    print("Data updated successfully -- Table --  max price per sim type !")


def insert_data_mysql_max_price_per_sim_type(batch_df, epoch_id):
    # Establish the connection to the MySQL database
    conn = mysql.connector.connect(
        host='localhost',
        user='root',
        password='aymane2002',
        database='smartphones'
    )
    cursor = conn.cursor()

    # Pass the DataFrame to your function for processing and insertion
    update_mysql_with_kpis(batch_df, insert_max_price_per_sim_type)

    # Commit and close the connection
    conn.commit()
    cursor.close()
    conn.close()

    print(f"Batch {epoch_id} processed and inserted into MySQL.")





####### 5. max_ram_per_brand ############
def insert_max_ram_per_brand(df, cursor):
    pandas_df = df.toPandas()
    pandas_df = pandas_df.dropna()
    delete_query = "delete from max_ram_per_brand"
    cursor.execute(delete_query)

    for index, row in pandas_df.iterrows():
        # Prepare the SQL query
        insert_query = """
               REPLACE INTO max_ram_per_brand (brand, max_ram, updated_at) 
               VALUES (%s, %s, NOW());
               """

        values = (
            row['brand'],
            row['max_ram']
        )

        cursor.execute(insert_query, values)

    print("Data updated successfully -- Table --  max ram per brand !")


def insert_data_mysql_max_ram_per_brand(batch_df, epoch_id):
    # Establish the connection to the MySQL database
    conn = mysql.connector.connect(
        host='localhost',
        user='root',
        password='aymane2002',
        database='smartphones'
    )
    cursor = conn.cursor()

    # Pass the DataFrame to your function for processing and insertion
    update_mysql_with_kpis(batch_df, insert_max_ram_per_brand)

    # Commit and close the connection
    conn.commit()
    cursor.close()
    conn.close()

    print(f"Batch {epoch_id} processed and inserted into MySQL.")









###### 6. max_rom_per_sim_type

def insert_max_rom_per_sim_type(df, cursor):
    pandas_df = df.toPandas()
    pandas_df = pandas_df.dropna()
    delete_query = "delete from max_rom_per_sim_type"
    cursor.execute(delete_query)

    for index, row in pandas_df.iterrows():
        # Prepare the SQL query
        insert_query = """
            REPLACE INTO max_rom_per_sim_type (sim_type, max_rom, updated_at) 
            VALUES (%s, %s, NOW());
                   """

        values = (
            row['sim_type'],
            row['max_rom']
        )

        cursor.execute(insert_query, values)

    print("Data updated successfully -- Table --  max rom per sim type !")


def insert_data_mysql_max_rom_per_sim_type(batch_df, epoch_id):
    # Establish the connection to the MySQL database
    conn = mysql.connector.connect(
        host='localhost',
        user='root',
        password='aymane2002',
        database='smartphones'
    )
    cursor = conn.cursor()

    # Pass the DataFrame to your function for processing and insertion
    update_mysql_with_kpis(batch_df, insert_max_rom_per_sim_type)

    # Commit and close the connection
    conn.commit()
    cursor.close()
    conn.close()

    print(f"Batch {epoch_id} processed and inserted into MySQL.")



###### 7.  max_battery_per_brand ############
def insert_max_battery_per_brand(df, cursor):
    pandas_df = df.toPandas()
    pandas_df = pandas_df.dropna()
    delete_query = "delete from max_battery_per_brand"
    cursor.execute(delete_query)

    for index, row in pandas_df.iterrows():
        # Prepare the SQL query
        insert_query = """
                 REPLACE INTO max_battery_per_brand (brand, max_battery, updated_at) 
                 VALUES (%s, %s, NOW());
                 """

        values = (
            row['brand'],
            row['max_battery']
        )

        cursor.execute(insert_query, values)

    print("Data updated successfully -- Table --  max battery per brand !")


def insert_data_mysql_max_battery_per_brand(batch_df, epoch_id):
    # Establish the connection to the MySQL database
    conn = mysql.connector.connect(
        host='localhost',
        user='root',
        password='aymane2002',
        database='smartphones'
    )
    cursor = conn.cursor()

    # Pass the DataFrame to your function for processing and insertion
    update_mysql_with_kpis(batch_df, insert_max_battery_per_brand)

    # Commit and close the connection
    conn.commit()
    cursor.close()
    conn.close()

    print(f"Batch {epoch_id} processed and inserted into MySQL.")


########### 8. max_screen_size_per_sim_type
def insert_max_screen_size_per_sim_type(df, cursor):
    pandas_df = df.toPandas()
    pandas_df = pandas_df.dropna()
    delete_query = "delete from max_screen_size_per_sim_type"
    cursor.execute(delete_query)

    for index, row in pandas_df.iterrows():
        insert_query = """
                     REPLACE INTO max_screen_size_per_sim_type (sim_type, max_screen_size, updated_at) 
                     VALUES (%s, %s, NOW());
                     """

        values = (
            row['sim_type'],
            row['max_screen_size']
        )

        cursor.execute(insert_query, values)

    print("Data updated successfully -- Table --  max screen size per sim type !")


def insert_data_mysql_max_screen_size_per_sim_type(batch_df, epoch_id):
    conn = mysql.connector.connect(
        host='localhost',
        user='root',
        password='aymane2002',
        database='smartphones'
    )
    cursor = conn.cursor()

    update_mysql_with_kpis(batch_df, insert_max_screen_size_per_sim_type)

    conn.commit()
    cursor.close()
    conn.close()


    print(f"Batch {epoch_id} processed and inserted into MySQL.")



def send_batch_email_notification():
    global processed_record_count

    if processed_record_count >= 2:
        processed_record_count=0
        send_email()

        print("Batch email notification sent.")






