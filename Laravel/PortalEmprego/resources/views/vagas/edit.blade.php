
@extends('layouts.app')




@section('content')
<div class="container">
    <h1 class="my-4">Criar Vaga</h1>


    @if ($errors->any())
        <div class="alert alert-danger">
            <strong>Oops!</strong> Houve alguns problemas com sua entrada.<br><br>
            <ul>
                @foreach ($errors->all() as $error)
                    <li>{{ $error }}</li>
                @endforeach
            </ul>
        </div>
    @endif


    <form action="{{ route('vagas.update', $vaga->id) }}" method="POST">
        @csrf
        @method('PUT')
        <div class="form-group">
            <label for="nome">Título:</label>
            <input type="text" name="titulo" class="form-control" value="{{$vaga->titulo}}">
        </div>


        <div class="form-group">
            <label for="descricao">Descrição:</label>
            <input type="text" name="descricao" class="form-control" value="{{$vaga->descricao}}">
        </div>


        <div class="form-group">
            <label for="localizacao">Localização:</label>
            <input type="text" name="localizacao" class="form-control" value="{{$vaga->localizacao}}">
        </div>


        <div class="form-group">
            <label for="salario">Salário:</label>
            <input type="text" name="salario" class="form-control" value="{{$vaga->salario}}">
        </div>


        <div class="form-group">
            <label for="empresa">Empresa:</label>
            <input type="text" name="empresa" class="form-control" value="{{$vaga->empresa}}">
        </div>


        <button type="submit" class="btn btn-primary">Enviar</button>
    </form>
</div>
@endsection


