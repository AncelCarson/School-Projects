﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        // Create a Random object called randomizer 
        // to generate random numbers.
        Random randomizer = new Random();

        // These integer variables store the numbers 
        // for the addition problem. 
        int addend1;
        int addend2;

        // These integer variables store the numbers 
        // for the subtraction problem. 
        int minuend;
        int subtrahend;

        // These integer variables store the numbers 
        // for the multiplication problem. 
        int multiplicand;
        int multiplier;

        // These integer variables store the numbers 
        // for the division problem. 
        int dividend;
        int divisor;

        // This integer variable keeps track of the 
        // remaining time.
        int timeLeft;

        // These booleans keep track of is an answer
        // is correct
        Boolean addTrue = false;
        Boolean subTrue = false;
        Boolean multTrue = false;
        Boolean divTrue = false;

        // This boolean keeps track of if the quiz
        // has been paused
        Boolean beenPaused = false;


        public Form1()
        {
            InitializeComponent();
            PauseButton.Enabled = false;
        }

        private void startButton_Click(object sender, EventArgs e)
        {
            if (beenPaused)
            {
                ResumeTheQuiz();
                startButton.Enabled = false;
                PauseButton.Enabled = true;
            }
            else
            {
                StartTheQuiz();
                startButton.Enabled = false;
                PauseButton.Enabled = true;
            }
        }

        private void PauseButton_Click_1(object sender, EventArgs e)
        {
            PauseTheQuiz();
            beenPaused = true;
            startButton.Enabled = true;
            startButton.Text = "Resume";
            PauseButton.Enabled = false;
        }

        /// <summary>
        /// Start the quiz by filling in all of the problems
        /// and starting the timer.
        /// </summary>
        public void StartTheQuiz()
        {
            // Fill in the addition problem.
            // Generate two random numbers to add.
            // Store the values in the variables 'addend1' and 'addend2'.
            addend1 = randomizer.Next(51);
            addend2 = randomizer.Next(51);

            // Convert the two randomly generated numbers
            // into strings so that they can be displayed
            // in the label controls.
            plusLeftLabel.Text = addend1.ToString();
            plusRightLabel.Text = addend2.ToString();

            // 'sum' is the name of the NumericUpDown control.
            // This step makes sure its value is zero before
            // adding any values to it.
            sum.Value = 0;

            // Fill in the subtraction problem.
            minuend = randomizer.Next(1, 101);
            subtrahend = randomizer.Next(1, minuend);
            minusLeftLabel.Text = minuend.ToString();
            minusRightLabel.Text = subtrahend.ToString();
            difference.Value = 0;

            // Fill in the multiplication problem.
            multiplicand = randomizer.Next(2, 11);
            multiplier = randomizer.Next(2, 11);
            timesLeftLabel.Text = multiplicand.ToString();
            timesRightLabel.Text = multiplier.ToString();
            product.Value = 0;

            // Fill in the division problem.
            divisor = randomizer.Next(2, 11);
            int temporaryQuotient = randomizer.Next(2, 11);
            dividend = divisor * temporaryQuotient;
            dividedLeftLabel.Text = dividend.ToString();
            dividedRightLabel.Text = divisor.ToString();
            quotient.Value = 0;

            // Set colors of answers
            sum.ForeColor = Color.Black;
            difference.ForeColor = Color.Black;
            product.ForeColor = Color.Black;
            quotient.ForeColor = Color.Black;

            // Start the timer.
            timeLeft = 30;
            timeLabel.Text = "30 seconds";
            timer1.Start();
        }

        public void PauseTheQuiz()
        {
            timer1.Stop();
            sum.Enabled = false;
            difference.Enabled = false;
            product.Enabled = false;
            quotient.Enabled = false;
        }

        public void ResumeTheQuiz()
        {
            timer1.Start();
            sum.Enabled = true;
            difference.Enabled = true;
            product.Enabled = true;
            quotient.Enabled = true;
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            if (CheckTheAnswer())
            {
                // If CheckTheAnswer() returns true, then the user 
                // got the answer right. Stop the timer  
                // and show a MessageBox.
                timer1.Stop();
                MessageBox.Show("You got all the answers right!",
                                "Congratulations!");
                startButton.Enabled = true;
                startButton.Text = "Start the quiz";
                PauseButton.Enabled = false;
                beenPaused = false;
            }
            else if (timeLeft > 0)
            {
                // If CheckTheAnswer() return false, keep counting
                // down. Decrease the time left by one second and 
                // display the new time left by updating the 
                // Time Left label.
                timeLeft--;
                if(timeLeft <= 5)
                {
                    timeLabel.ForeColor = Color.Red;
                }
                else
                {
                    timeLabel.ForeColor = Color.Black;
                }
                timeLabel.Text = timeLeft + " seconds";
            }
            else
            {
                // If the user ran out of time, stop the timer, show 
                // a MessageBox, and fill in the answers.
                timer1.Stop();
                timeLabel.Text = "Time's up!";
                MessageBox.Show("You didn't finish in time.", "Sorry");
                sum.Value = addend1 + addend2;
                difference.Value = minuend - subtrahend;
                product.Value = multiplicand * multiplier;
                quotient.Value = dividend / divisor;
                startButton.Enabled = true;
                startButton.Text = "Start the quiz";
                PauseButton.Enabled = false;
                beenPaused = false;
            }
        }

        /// <summary>
        /// Check the answer to see if the user got everything right.
        /// </summary>
        /// <returns>True if the answer's correct, false otherwise.</returns>
        private bool CheckTheAnswer()
        {
            if (addend1 + addend2 == sum.Value)
            {
                addTrue = true;
                sum.ForeColor = Color.Green;
            }
            else
            {
                addTrue = false;
                sum.ForeColor = Color.Black;
            }

            if (minuend - subtrahend == difference.Value)
            {
                subTrue = true;
                difference.ForeColor = Color.Green;
            }
            else
            {
                subTrue = false;
                difference.ForeColor = Color.Black;
            }

            if (multiplicand * multiplier == product.Value)
            {
                multTrue = true;
                product.ForeColor = Color.Green;
            }
            else
            {
                multTrue = false;
                product.ForeColor = Color.Black;
            }

            if (dividend / divisor == quotient.Value)
            {
                divTrue = true;
                quotient.ForeColor = Color.Green;
            }
            else
            {
                divTrue = false;
                quotient.ForeColor = Color.Black;
            }

            if (addTrue && subTrue && multTrue && divTrue)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        private void answer_Enter(object sender, EventArgs e)
        {
            // Select the whole answer in the NumericUpDown control.
            NumericUpDown answerBox = sender as NumericUpDown;

            if (answerBox != null)
            {
                int lengthOfAnswer = answerBox.Value.ToString().Length;
                answerBox.Select(0, lengthOfAnswer);
            }
        }
    }
}
