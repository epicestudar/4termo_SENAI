@extends('layouts.app')




@section('content')
    <div class="container">
        <h1 class="my-4">Vagas</h1>


        @if ($message = Session::get('success'))
            <div class="alert alert-success">
                <p>{{ $message }}</p>
            </div>
        @endif


        <a class="btn btn-success mb-2" href="{{ route('vagas.create') }}"> Criar Nova Vaga</a>


        <table class="table table-bordered">
            <tr>
                <th>Nº</th>
                <th>Título</th>
                <th>Descrição</th>
                <th>Localização</th>
                <th>Salário</th>
                <th>Empresa</th>
                <th width="280px">Ação</th>
            </tr>
            @foreach ($vagas as $vaga)
            <tr>
                <td>{{ $loop->iteration }}</td>
                <td>{{ $vaga->titulo }}</td>
                <td>{{ $vaga->descricao }}</td>
                <td>{{ $vaga->localizacao}}</td>
                <td>{{ $vaga->salario }}</td>
                <td>{{ $vaga->empresa }}</td>
                <td>
                    <form action="{{ route('vagas.destroy', $vaga->id) }}" method="POST">
                        <a class="btn btn-primary" href="{{ route('vagas.edit', $vaga->id) }}">Editar</a>
                        @csrf
                        @method('DELETE')
                        <button type="submit" class="btn btn-danger">Deletar</button>
                    </form>
                </td>
            </tr>
            @endforeach
        </table>
    </div>
@endsection
