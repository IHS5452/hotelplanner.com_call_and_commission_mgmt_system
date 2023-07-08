<h1>Hotelplanner.com Sales and Managment system (Not finished yet)</h1>

<p><b>About this app</b>: This app is a companion app for hotelplanner.com independent hotel planners.</p>


<p><b>Backstory</b>: I was one of their commission-based hotel planners, and relized that their system is not very orgnazationaly freindly. I wanted to make an app that did what I need to manage my calls, commissions, and QA tracking.</p>
</p> Since then, I was kicked off the platform for not making sales, and have published this app here for my portfolio.</p>


<h1>ALL planned features</h1>
<ul>
<li>Clock In and out, and have the clock in and out time (Called "Time Punches") be recorded in a MySQL Database</li>
<li>Recover clock in status when app is accidently closed</li>
<li>Add calls with and without a linked sale for bookkeeping</li>
<li>Pull up previous sales to edit the data recorded</li>
<li>Pull up previous time punches to edit the data recorded</li>
<li>Generate montly reports into a excel file</li>
<li>view montly reports in the app</li>
</ul>

<h1>MySQL table to add</h1>
<h3>Note: The database is called "hotelplannersystem", the username is set to the default root username, and the password will need changing. it is defaulted to "enter-password-here"</h3>

-- Table: time_punches<br>
CREATE TABLE IF NOT EXISTS time_punches (
    punch_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    clock_in_time VARCHAR(500),
    clock_out_time VARCHAR(500),
    is_recovered BOOLEAN,
    UNIQUE KEY (user_id, clock_in_time)
);

-- Table: calls<br>
CREATE TABLE IF NOT EXISTS calls (
    call_id INT AUTO_INCREMENT PRIMARY KEY,
    call_status VARCHAR(50),
    call_date DATE,
    is_prepaid BOOLEAN,
    linked_sale_id INT,
    FOREIGN KEY (linked_sale_id) REFERENCES sales(sale_id)
);

-- Table: sales<br>
CREATE TABLE IF NOT EXISTS sales (
    sale_id INT AUTO_INCREMENT PRIMARY KEY,
    call_id INT,
    call_status VARCHAR(50),
    call_date DATE,
    is_prepaid BOOLEAN,
    check_in_date DATE,
    check_out_date DATE,
    is_paid_out BOOLEAN,
    paid_out_date DATE,
    hotel_name VARCHAR(500),
    total_bill INT,
    commission_percentage INT,
    total_commission INT,
    is_canceled_booking BOOLEAN,
    canceled_date DATE,
    FOREIGN KEY (call_id) REFERENCES calls(call_id)
);

-- Table: monthly_reports<br>
CREATE TABLE IF NOT EXISTS monthly_reports (
    report_id INT AUTO_INCREMENT PRIMARY KEY,
    report_month INT,
    report_year INT,
    report_file_path VARCHAR(500)
);

-- Table: vars<br>
CREATE TABLE IF NOT EXISTS vars (
    current_timesheet_id VARCHAR(50),
    is_clocked_in BOOLEAN
);

 --Table: timesheets<br>
CREATE TABLE IF NOT EXISTS timesheets (
    timesheet_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    clock_in_time VARCHAR(500),
    clock_out_time VARCHAR(500),
    hours_worked INT,
    sales_made INT,
    calls_received INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Table: users<br>
CREATE TABLE IF NOT EXISTS users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50),
    email VARCHAR(100)
);

-- Insert initial data into vars table<br>
INSERT INTO vars (current_timesheet_id, is_clocked_in) VALUES ('NA', false);

);

insert into vars VALUES("NA","false");

