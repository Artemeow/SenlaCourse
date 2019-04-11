using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Калькулятор
{
    public interface ICalculatorForm
    {
        string Display { get; set; }
        event EventHandler EquallyClick;
    }

    public partial class CalculatorForm : Form, ICalculatorForm
    {
        public CalculatorForm()
        {
            InitializeComponent();
            butEight.Tag = "8";
            butNine.Tag = "9";
            butEqually.Click += butEqually_Click;
        }

        #region ICalculatorForm
        public string Display
        {
            get { return fldDisplay.Text; }
            set { fldDisplay.Text = value; }
        }

        public event EventHandler EquallyClick;
        #endregion

        private void Calculator_Load(object sender, EventArgs e)
        {

        }

        private void butEqually_Click(object sender, EventArgs e)
        {
            if (EquallyClick != null) EquallyClick(this, EventArgs.Empty);
        }

        #region События кнопок
        private void butDivide_Click(object sender, EventArgs e)
        {
            Display += " / ";
        }

        private void butMultiply_Click(object sender, EventArgs e)
        {
            Display += " * ";
        }

        private void butMinus_Click(object sender, EventArgs e)
        {
            Display += " - ";
        }

        private void butPlus_Click(object sender, EventArgs e)
        {
            Display += " + ";
        }

        private void butRightBracket_Click(object sender, EventArgs e)
        {
            Display += ")";
        }

        private void butLeftBracket_Click(object sender, EventArgs e)
        {
            Display += "(";
        }

        private void butNull_Click(object sender, EventArgs e)
        {
            Display += "0";
        }

        private void butNine_Click(object sender, EventArgs e)
        {
            Display += "9";
        }

        private void butEight_Click(object sender, EventArgs e)
        {
            Display += (sender as Button).Tag as string;
        }

        private void butSeven_Click(object sender, EventArgs e)
        {
            Display += "7";
        }

        private void butSix_Click(object sender, EventArgs e)
        {
            Display += "6";
        }

        private void butFive_Click(object sender, EventArgs e)
        {
            Display += "5";
        }

        private void butFour_Click(object sender, EventArgs e)
        {
            Display += "4";
        }

        private void butThree_Click(object sender, EventArgs e)
        {
            Display += "3";
        }

        private void butTwo_Click(object sender, EventArgs e)
        {
            Display += "2";
        }

        private void butOne_Click(object sender, EventArgs e)
        {
            Display += "1";
        }
        

        private void butClearAll_Click(object sender, EventArgs e)
        {
            Display = "";
        }

        private void butClearLast_Click(object sender, EventArgs e)
        {
            try
            {
                int length = Display.Length;
                Display = Display.Remove(length - 1, 1);
            }
            catch
            {

            }
        }
        #endregion
    }
}
