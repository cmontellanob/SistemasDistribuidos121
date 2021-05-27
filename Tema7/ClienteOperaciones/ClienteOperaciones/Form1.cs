using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClienteOperaciones
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int a = int.Parse(txtA.Text);
            int b = int.Parse(txtB.Text);

            ServicioOperaciones.OperacionesSoapClient op = new ServicioOperaciones.OperacionesSoapClient();
            int c = op.Suma(a, b);
            lblResultado.Text = c.ToString();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            int a = int.Parse(txtA.Text);
            int b = int.Parse(txtB.Text);

            ServicioOperaciones.OperacionesSoapClient op = new ServicioOperaciones.OperacionesSoapClient();
            int c = op.Resta(a, b);
            lblResultado.Text = c.ToString();
        }
    }
}
