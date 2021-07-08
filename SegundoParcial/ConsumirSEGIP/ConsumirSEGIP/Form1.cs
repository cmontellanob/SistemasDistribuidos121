using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ConsumirSEGIP
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            ServicioSegip.wsSEGIPSoapClient cl = new ServicioSegip.wsSEGIPSoapClient();
            ServicioSegip.Persona p=cl.ObtenerDatos(txtCarnet.Text); 
            if (p!=null)
            {
                txtNombres.Text = p.nombres;
                txtPrimerApellido.Text = p.primerapellido;
                txtSegundoApellido.Text = p.segundoapellido;
            }
        }

        private void label7_Click(object sender, EventArgs e)
        {
            ServicioSegip.wsSEGIPSoapClient cl = new ServicioSegip.wsSEGIPSoapClient();
            ServicioSegip.wsSEGIPSoap res = (ServicioSegip.wsSEGIPSoap)cl.ComprobarDatos(txtCarnet.Text, txtNombres.Text,"","","","","");
        }
    }
}
