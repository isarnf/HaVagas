package br.edu.ifsp.aluno.ads.havagas

class Pessoa (nomeCompleto: String, email: String, desejaReceberEmail: String, telefone: String,
              tipoTelefone: String, telefoneCelular: String, sexo: String, dataNasc: String,
              formacao: String, anoFormatura: String, instituicao: String, tituloMonografia: String,
              orientador: String, vagasInteresse: String) {

    var nomeCompleto: String
    var email: String
    var desejaReceberEmail: String
    var telefone: String
    var tipoTelefone: String
    var telefoneCelular: String
    var sexo: String
    var dataNasc: String
    var formacao: String
    var anoFormatura: String
    var instituicao: String
    var tituloMonografia: String
    var orientador: String
    var vagasInteresse: String

    init {
        this.nomeCompleto = nomeCompleto
        this.email = email
        this.desejaReceberEmail = desejaReceberEmail
        this.telefone = telefone
        this.tipoTelefone=tipoTelefone
        this.telefoneCelular = telefoneCelular
        this.sexo = sexo
        this.dataNasc = dataNasc
        this.formacao = formacao
        this.anoFormatura = anoFormatura
        this.instituicao = instituicao
        this.tituloMonografia = tituloMonografia
        this.orientador = orientador
        this.vagasInteresse = vagasInteresse
    }

    override fun toString(): String {
        return "Nome completo: '$nomeCompleto', \n" +
                "E-mail: '$email', \n" +
                "Deseja receber e-mails: '$desejaReceberEmail', \n" +
                "Telefone: '$telefone', \n" +
                "Tipo telefone: '$tipoTelefone', \n" +
                "Celular: '$telefoneCelular', \n" +
                "Sexo: '$sexo', \n" +
                "Data nascimento: '$dataNasc', \n" +
                "Formação: '$formacao', \n" +
                "Ano de conclusão: '$anoFormatura', \n" +
                "Instituição: '$instituicao', \n" +
                "Título da monografia: '$tituloMonografia', \n" +
                "Orientador: '$orientador', \n" +
                "Vagas de interesse: '$vagasInteresse')"
    }


}