@extends('layouts.app')


@section('content')
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <img src="/assets/img/img1.png" class="img-fluid" alt="{{ $vaga->titulo }}">
            </div>
            <div class="col-md-6">
                <h2>{{ $vaga->titulo }}</h2>
                <h2>{{ $vaga->empresa }}</h2>
                <p>{{ $vaga->descricao }}</p>
                <p>{{ $vaga->localizacao }}</p>
                <p>Preço: R$ {{ $vaga->salario }}</p>


                <form method="POST" action="{{ route('inscricao.add', $vaga->id) }}">
                    @csrf
                    <button type="submit" class="btn btn-primary">Fazer Inscrição</button>
                </form>
            </div>
        </div>
    </div>
@endsection
