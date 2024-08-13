<?php


namespace App\Http\Controllers;


use Illuminate\Http\Request;
use App\Models\Usuario;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;




class UsuarioController extends Controller
{
    // Exibir o formulário de login
    public function showLoginForm()
    {
        return view('usuarios.login');
    }


    // Processar o login do usuário
    public function login(Request $request)
    {
        // Validações para o login
        $credentials = $request->validate([
            'email' => ['required', 'email'],
            'password' => ['required'],
        ]);


        // Tenta autenticar com o guard 'usuario'
        if (Auth::guard('usuario')->attempt($credentials)) {
            $request->session()->regenerate(); // Regenera a sessão para evitar fixação de sessão
            return redirect()->intended('/dashboard');
        }


        // Se falhar, retorna com erro
        return back()->withErrors([
            'email' => 'As credenciais não correspondem aos nossos registros.',
        ])->onlyInput('email');
    }


    // Exibir o formulário de registro
    public function showRegisterForm()
    {
        return view('usuarios.registro');
    }


    // Processar o registro de um novo usuário
    public function registro(Request $request)
    {
       // Validações para o registro
    $request->validate([
        'nome' => 'required|string|max:255',
        'email' => 'required|string|email|max:255|unique:usuarios',
        'password' => 'required|string|min:8|confirmed',
        'tipo' => 'required|in:usuario,empresa',
       'cnpj' => 'nullable|required_if:tipo,empresa|string',
        'nome_empresa' => 'nullable|required_if:tipo,empresa|string|max:255'
    ]);

    // Cria um novo usuário
    $usuario = Usuario::create([
        'nome' => $request->nome,
        'email' => $request->email,
        'password' => Hash::make($request->password),
        'tipo' => $request->tipo,
        'cnpj' => $request->tipo === 'empresa' ? $request->cnpj : null,
        'nome_empresa' => $request->tipo === 'empresa' ? $request->nome_empresa : null
    ]);


        // Faz login automático do novo usuário
        Auth::guard('usuario')->login($usuario);


        return redirect('/dashboard');
    }


    // Realizar o logout do usuário
    public function logout(Request $request)
    {
        Auth::guard('usuario')->logout(); // Logout do guard 'usuario'
        $request->session()->regenerateToken(); // Regenera o token da sessão


        $request->session()->invalidate();
        $request->session()->regenerate();// Invalida a sessão


        return redirect('/');
    }
}
