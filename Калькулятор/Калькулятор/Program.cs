using Calculator.BL;
using System;
using System.Windows.Forms;

namespace Калькулятор
{
    static class Program
    {
        /// <summary>
        /// Главная точка входа для приложения.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);

            RPN rpn = new RPN();
            CalculatorForm form = new CalculatorForm();
            Presenter presenter = new Presenter(form, rpn);

            Application.Run(form);
        }
        
    }
}
