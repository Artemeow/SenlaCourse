using Calculator.BL;
using System;

namespace Калькулятор
{
    class Presenter
    {
        private readonly ICalculatorForm calculatorForm;
        private readonly ICalculable calculable;

        public Presenter(ICalculatorForm calculatorForm, ICalculable calculable)
        {
            this.calculatorForm = calculatorForm;
            this.calculable = calculable;

            calculatorForm.EquallyClick += CalculatorForm_EquallyClick;
        }

        private void CalculatorForm_EquallyClick(object sender, EventArgs e)
        {
            try
            {
                calculatorForm.Display = calculable.Calculate(calculatorForm.Display).ToString();
            }
            catch
            {
                calculatorForm.Display = "Проверьте введённые данные";
            }
        }
    }
}
