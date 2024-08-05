<?php

namespace Database\Seeders;

use App\Models\Produto;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Faker\Factory as Faker;
use Illuminate\Support\Testing\Fakes\Fake;

class ProdutoSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $faker = Faker::create();

        for ($i=1; $i <= 50; $i++) { 
            Produto::create([
                'nome' => 'Produto ' . $i,
                'descricao' => $faker->sentence,
                'preco' => $faker->randomFloat(2, 1, 1000),
                'quantidade' => $faker->numberBetween(1, 100)
            ]);
        }
    }
}
