﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace ClienteOperaciones.ServicioOperaciones {
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="ServicioOperaciones.OperacionesSoap")]
    public interface OperacionesSoap {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Suma", ReplyAction="*")]
        int Suma(int a, int b);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Suma", ReplyAction="*")]
        System.Threading.Tasks.Task<int> SumaAsync(int a, int b);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Resta", ReplyAction="*")]
        int Resta(int a, int b);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Resta", ReplyAction="*")]
        System.Threading.Tasks.Task<int> RestaAsync(int a, int b);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Multiplicacion", ReplyAction="*")]
        int Multiplicacion(int a, int b);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Multiplicacion", ReplyAction="*")]
        System.Threading.Tasks.Task<int> MultiplicacionAsync(int a, int b);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Division", ReplyAction="*")]
        int Division(int a, int b);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Division", ReplyAction="*")]
        System.Threading.Tasks.Task<int> DivisionAsync(int a, int b);
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface OperacionesSoapChannel : ClienteOperaciones.ServicioOperaciones.OperacionesSoap, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class OperacionesSoapClient : System.ServiceModel.ClientBase<ClienteOperaciones.ServicioOperaciones.OperacionesSoap>, ClienteOperaciones.ServicioOperaciones.OperacionesSoap {
        
        public OperacionesSoapClient() {
        }
        
        public OperacionesSoapClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public OperacionesSoapClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public OperacionesSoapClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public OperacionesSoapClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        public int Suma(int a, int b) {
            return base.Channel.Suma(a, b);
        }
        
        public System.Threading.Tasks.Task<int> SumaAsync(int a, int b) {
            return base.Channel.SumaAsync(a, b);
        }
        
        public int Resta(int a, int b) {
            return base.Channel.Resta(a, b);
        }
        
        public System.Threading.Tasks.Task<int> RestaAsync(int a, int b) {
            return base.Channel.RestaAsync(a, b);
        }
        
        public int Multiplicacion(int a, int b) {
            return base.Channel.Multiplicacion(a, b);
        }
        
        public System.Threading.Tasks.Task<int> MultiplicacionAsync(int a, int b) {
            return base.Channel.MultiplicacionAsync(a, b);
        }
        
        public int Division(int a, int b) {
            return base.Channel.Division(a, b);
        }
        
        public System.Threading.Tasks.Task<int> DivisionAsync(int a, int b) {
            return base.Channel.DivisionAsync(a, b);
        }
    }
}
