import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
import os
from dotenv import load_dotenv

load_dotenv()

def send_email():
    sender_email = os.getenv("EMAIL_SENDER")
    receiver_email = os.getenv("EMAIL_RECEIVER")
    password = os.getenv("EMAIL_PASSWORD")
    subject = os.getenv("EMAIL_SUBJECT")
    body_template = os.getenv("EMAIL_BODY")
    dashboard_link = os.getenv("DASHBOARD_LINK")

    body = body_template.format(link=dashboard_link)

    message = MIMEMultipart()
    message["From"] = sender_email
    message["To"] = receiver_email
    message["Subject"] = subject

    message.attach(MIMEText(body, "plain"))

    server = smtplib.SMTP("smtp.gmail.com", 587)
    server.starttls()
    server.login(sender_email, password)

    server.sendmail(sender_email, receiver_email, message.as_string())
    server.quit()

    print("Email sent successfully!")



