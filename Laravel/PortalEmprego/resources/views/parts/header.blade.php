<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            {{-- <a class="navbar-brand" href="{{ url('') }}">Portal de Empregos</a> --}}
            @if (Auth::check())
                @if (Auth::user()->isEmpresa())
                <div>
                    <a href="/vagas">Acesse dashboard de vagas</a>
                </div>
                @endif
                <div>
                    <h3>Olá, {{ Auth::user()->nome }}</h3>
                </div>
                <div>
                    <form action="/logout" method="POST">
                        @csrf
                        <input type="submit" value="Sair">
                    </form>
                </div>
                {{-- @endif --}}
                @else
                <div class="nav-bar">
                    <a href="/login"><h2>Login</h2></a>
                    <a href="/registro"><h2>Registre-se</h2></a>
                </div>
            @endif
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="{{ url('/jobs') }}">Vagas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="{{ url('/about') }}">Sobre Nós</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="{{ url('/contact') }}">Contato</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-primary text-white" href="{{ url('/login') }}">Login</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
