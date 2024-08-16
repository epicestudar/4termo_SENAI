@extends('layouts.app')




@section('content')
    <h1>Dashboard de Vagas</h1>




    <form method="GET" action="{{ route('dashboard') }}">
        <input type="search" name="search" placeholder="Pesquisar vagas..." value="{{ request('search') }}">
        <button type="submit">Pesquisar</button>
    </form>




    <div class="row">
        @foreach ($vagas as $vaga)
            <div class="col-md-4">
                <div class="card">
                    <img src="/assets/img/img1.png" class="card-img-top" alt="{{ $vaga->titulo }}">
                    <div class="card-body">
                        <h5 class="card-title">{{ $vaga->titulo }}</h5>
                        <h5 class="card-title">{{ $vaga->empresa }}</h5>
                        <p class="card-text">{{ $vaga->descricao }}</p>
                        <p class="card-text">Preço: R$ {{ $vaga->salario }}</p>
                        <a href="{{ route('vagas.show', $vaga->id) }}" class="btn btn-primary">Ver Vaga</a>
                    </div>
                </div>
            </div>
        @endforeach
    </div>
@endsection
