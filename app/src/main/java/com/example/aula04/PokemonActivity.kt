package com.example.aula04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import com.example.aula04.databinding.ActivityPokemonBinding

class PokemonActivity : AppCompatActivity() {
    //criar variavel que represente o binding/xml inteiro.
    //Nome estilo classe. lateinit > vai ser inicializado depois, pois por padrão o kotlin necessita que ela tenha um valor.
    lateinit var binding : ActivityPokemonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inflate > carrega xml da tela com base no XML da classe e vai ser carregado na variavel binding
        binding = ActivityPokemonBinding.inflate(layoutInflater)
        //faz a tela aparecer, com base no que foi usado para carregar a tela /\
        setContentView(binding.root)

//        val spinner: Spinner = findViewById(R.id.spinner)
//        val imageView: ImageView = findViewById(R.id.imageView)
//        val button: Button = findViewById(R.id.button)

        //arrayOf, array com essas opções de pokemon.
        val pokemons = arrayOf("Selecione", "Bulbassauro", "Charmander", "Squirtle", "Vulpix", "Giratina")
        // faz ligação de duas coisas, necessita instanciar. Chamar construtor de uma classe, no caso ArrayAdapter.
        // 3 parametros: contexto da atividade this, item do spinner com o layout do android(recurso do android diferente do meu R), e o array que vai ficar no spinner.
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, pokemons)
        //Adapter configurado
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        //isso faz o que carrega o adapter.
        binding.spinner.adapter = adapter

        //fazer closure de quando o spinner muda
        // classe anonima, cria já instanciando a classe. no kotlin cria objeto, instancia direta, um objeto é uma instancia. cria instancia sem ter classe.
        // object < já cria o objeto sem ter a classe. no kotlin tem que derivar de alguma classe/interface.
        //funções: onitemselected >
        // onnothingseleted > tinha selecionado algo, mas o combo recarregou/atualizou, apareceu novos valores.
        //to do < nao foi implementado e ele aparece la embaixo. é uma palavra reservada
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            //implementação dos protocolos da interface. Closure/função seta
            override fun onItemSelected(adapter: AdapterView<*>?, spinner: View?, posicao: Int, id: Long) {
                //onde que vai ser feito as coisas. when > é tipo um switch só que melhor, mais de um comando necessita de {} para cada caso.
                when(posicao) {
                    1 -> binding.imageView.setImageResource(R.drawable.bulbassauro)
                    2 -> binding.imageView.setImageResource(R.drawable.charmander)
                    3 -> binding.imageView.setImageResource(R.drawable.squirtle) // setimageresource so recebe int.
                    4 -> binding.imageView.setImageResource(R.drawable.vulpixalola)
                    5 -> binding.imageView.setImageResource(R.drawable.giratina)
                    else -> binding.imageView.setImageDrawable(null) //nenhuma imagem, nada selecionado. setimagedrawable pode receber null.
                }
            }

            //internacionalizar / traduzir. Editor de tradução dentro do android. dentro do res.

            override fun onNothingSelected(adapter: AdapterView<*>?) {
            }
        }
        //executa quando o botão for clicado
        binding.button.setOnClickListener {
            //valor do item do spinner
            when(binding.spinner.selectedItemPosition) {
                1 -> showMsg("Bulbasaur", "Grama/Veneno", this)
                2 -> showMsg("Charmander", "Fogo", this)
                3 -> showMsg("Squirtle", "Água", this)
                4 -> showMsg("Vulpix", "Gelo", this)
                5 -> showMsg("Giratina", "Fantasma/Dragão", this)
                else -> showMsg("Erro!", "Nenhum pokémon selecionado!", this)
            }
        }
    }



}