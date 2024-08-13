document.addEventListener('DOMContentLoaded', function () {
    const tipoSelect = document.getElementById('tipo');
    const cnpjGroup = document.getElementById('cnpj-group');
    const nomeEmpresaGroup = document.getElementById('nome_empresa-group');

    tipoSelect.addEventListener('change', function () {
        if (tipoSelect.value === 'empresa') {
            cnpjGroup.style.display = 'block';
            nomeEmpresaGroup.style.display = 'block';
        } else {
            cnpjGroup.style.display = 'none';
            nomeEmpresaGroup.style.display = 'none';
        }
    });
});
