@extends('layouts.app')

@section('content')
<div class="container">
    <h2>Dashboard - Usuário</h2>
    <form action="{{route('usuarios.logout')}}" method="POST">
        @csrf
        <input type="submit" value="Sair">
    </form>
</div>
@endsection
