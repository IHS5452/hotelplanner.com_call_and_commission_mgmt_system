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
''
CREATE TABLE `sales` (
	`CallID` VARCHAR(25),
	`call_status` VARCHAR(50),
	`call_date` DATE,
	`is_prepaid` VARCHAR(50),
	`check_in_date` DATE,
	`check_out_date` DATE,
	`is_paid_out` VARCHAR(2),
	`paid_out_date` VARCHAR(50),
	`hotel_name` VARCHAR(500),
	`total_bill` INT(500),
	`commission_percentage` INT,
	`total_commission` INT,
	`is_canceled_booking` BOOLEAN,
	`canceled_date` VARCHAR(50)
);



CREATE TABLE `timesheets` (
	`TSID` VARCHAR(25),
	`clockInTime` VARCHAR(50),
	`clockInDate` VARCHAR(50),
	`clockOutTime` VARCHAR(50),
	`clockOutDate` VARCHAR(50),
	`hoursWorked` VARCHAR(50),
	`salesMade` VARCHAR(50),
	`callsRcvd` VARCHAR(50)
);



CREATE TABLE `vars` (
	`crntTSID` VARCHAR(50),
	`isClockedIn` VARCHAR(15)
);

''
