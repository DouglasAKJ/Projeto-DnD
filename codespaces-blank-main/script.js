//misc
const botao = document.getElementById("botao");
const content = document.getElementById("content");
const body = document.getElementsByTagName("body");

//inputs
const inputAtributo = document.getElementsByName("atributo");

//botoes
const botaoCombat = document.getElementById("combat-btn");
const botaoSpell = document.getElementById("spell-btn");
const botaoAbout = document.getElementById("about-btn");
const botaoInv = document.getElementById("inv-btn");
const addBotao = document.getElementById("add-botao");
const addSpell = document.getElementById("add-spell");
const botaoDelete = document.getElementById("botaoDelete");
const botaoFicha = document.getElementById("botaoFicha");

//nav
const navCombat = document.getElementById("nav-ataque2");
const navCombat2 = document.getElementById("nav-ataque");
const navSpell = document.getElementById("nav-spells");
const navInv = document.getElementById("nav-inventario");

//spells
const nineSpell = document.getElementById("level9");
const eightSpell = document.getElementById("level8");
const sevenSpell = document.getElementById("level7");
const sixSpell = document.getElementById("level6");
const fiveSpell = document.getElementById("level5");
const fourSpell = document.getElementById("level4");
const threeSpell = document.getElementById("level3");
const twoSpell = document.getElementById("level2");
const oneSpell = document.getElementById("level1");
const cantripSpell = document.getElementById("truques");

//atributos
const dexAtributo = document.getElementById("destreza");
const consAtributo = document.getElementById("constituicao");
const forcaAtributo = document.getElementById("forca");
const intAtributo = document.getElementById("inteligencia");
const carismaAtributo = document.getElementById("carisma");
const sabAtributo = document.getElementById("sabedoria");

//mods
const dexMod = document.getElementById("destrezaMod");
const consMod = document.getElementById("constituicaoMod");
const forcaMod = document.getElementById("forcaMod");
const intMod = document.getElementById("inteligenciaMod");
const carismaMod = document.getElementById("carismaMod");
const sabMod = document.getElementById("sabedoriaMod");

//outros
const iniciativa = document.getElementById("iniciativa");
const proficiencia = document.getElementById("proficiencia");
const nivel = document.getElementById("nivel");

//pericias
const acrobacia = document.getElementById("acrobacia");
const arcanismo = document.getElementById("arcanismo");
const atletismo = document.getElementById("atletismo");
const atuacao = document.getElementById("atuacao");
const engancao = document.getElementById("enganacao");
const furtividade = document.getElementById("furtividade");
const historia = document.getElementById("historia");
const intimidacao = document.getElementById("intimidacao");
const intuicao = document.getElementById("intuicao");
const investigacao = document.getElementById("investigacao");
const lidarAnimais = document.getElementById("lidaranimais");
const medicina = document.getElementById("medicina");
const natureza = document.getElementById("natureza");
const percepcao = document.getElementById("percepcao");
const persuasao = document.getElementById("persuasao");
const prestidigitacao = document.getElementById("prestidigitacao");
const religiao = document.getElementById("religiao");
const sobrevivencia = document.getElementById("sobrevivencia");



  addBotao.addEventListener("click", () => {
    const newAtk = document.createElement("div");
    newAtk.innerHTML = '<div class="linha"> <input type="text" name="ataque1" id="ataque1" placeholder="nome"> <input type="text" name="ataque1" id="ataque1" placeholder="bonus" style="width: 40px;" > <input type="text" name="ataque1" id="ataque1" placeholder="dano" style="width: 100px;"> </div>'
    navCombat2.appendChild(newAtk);
  })

  function adicionarCantrip(){
    const newSpell = document.createElement("div");
    newSpell.innerHTML = `<div class="linha">
                        <input type="text" name="spell" id="spell-name" placeholder="nome">
                        <input type="text" name="spell-time" id="spell-time" placeholder="casting time" >
                        <input type="text" name="spell-range" id="spell-range" placeholder="range" >
                        <input type="text" name="spell-effect" id="spell-effect" placeholder="efeito" >
                        </div>`
    cantripSpell.appendChild(newSpell);
  }

   function adicionarSpellLvl1(){
    const newSpell = document.createElement("div");
    newSpell.innerHTML = `<div class="linha">
                        <input type="text" name="spell" id="spell-name" placeholder="nome">
                        <input type="text" name="spell-time" id="spell-time" placeholder="casting time" >
                        <input type="text" name="spell-range" id="spell-range" placeholder="range" >
                        <input type="text" name="spell-effect" id="spell-effect" placeholder="efeito" >
                        </div>`
    oneSpell.appendChild(newSpell);
  }

     function adicionarSpellLvl2(){
    const newSpell = document.createElement("div");
    newSpell.innerHTML = `<div class="linha">
                        <input type="text" name="spell" id="spell-name" placeholder="nome">
                        <input type="text" name="spell-time" id="spell-time" placeholder="casting time" >
                        <input type="text" name="spell-range" id="spell-range" placeholder="range" >
                        <input type="text" name="spell-effect" id="spell-effect" placeholder="efeito" >
                        </div>`
    twoSpell.appendChild(newSpell);
  }

     function adicionarSpellLvl3(){
    const newSpell = document.createElement("div");
    newSpell.innerHTML = `<div class="linha">
                        <input type="text" name="spell" id="spell-name" placeholder="nome">
                        <input type="text" name="spell-time" id="spell-time" placeholder="casting time" >
                        <input type="text" name="spell-range" id="spell-range" placeholder="range" >
                        <input type="text" name="spell-effect" id="spell-effect" placeholder="efeito" >
                        </div>`
    threeSpell.appendChild(newSpell);
  }

     function adicionarSpellLvl4(){
    const newSpell = document.createElement("div");
    newSpell.innerHTML = `<div class="linha">
                        <input type="text" name="spell" id="spell-name" placeholder="nome">
                        <input type="text" name="spell-time" id="spell-time" placeholder="casting time" >
                        <input type="text" name="spell-range" id="spell-range" placeholder="range" >
                        <input type="text" name="spell-effect" id="spell-effect" placeholder="efeito" >
                        </div>`
    fourSpell.appendChild(newSpell);
  }

     function adicionarSpellLvl5(){
    const newSpell = document.createElement("div");
    newSpell.innerHTML = `<div class="linha">
                        <input type="text" name="spell" id="spell-name" placeholder="nome">
                        <input type="text" name="spell-time" id="spell-time" placeholder="casting time" >
                        <input type="text" name="spell-range" id="spell-range" placeholder="range" >
                        <input type="text" name="spell-effect" id="spell-effect" placeholder="efeito" >
                        </div>`
    fiveSpell.appendChild(newSpell);
  }

     function adicionarSpellLvl6(){
    const newSpell = document.createElement("div");
    newSpell.innerHTML = `<div class="linha">
                        <input type="text" name="spell" id="spell-name" placeholder="nome">
                        <input type="text" name="spell-time" id="spell-time" placeholder="casting time" >
                        <input type="text" name="spell-range" id="spell-range" placeholder="range" >
                        <input type="text" name="spell-effect" id="spell-effect" placeholder="efeito" >
                        </div>`
    sixSpell.appendChild(newSpell);
  }

     function adicionarSpellLvl7(){
    const newSpell = document.createElement("div");
    newSpell.innerHTML = `<div class="linha">
                        <input type="text" name="spell" id="spell-name" placeholder="nome">
                        <input type="text" name="spell-time" id="spell-time" placeholder="casting time" >
                        <input type="text" name="spell-range" id="spell-range" placeholder="range" >
                        <input type="text" name="spell-effect" id="spell-effect" placeholder="efeito" >
                        </div>`
    sevenSpell.appendChild(newSpell);
  }

     function adicionarSpellLvl8(){
    const newSpell = document.createElement("div");
    newSpell.innerHTML = `<div class="linha">
                        <input type="text" name="spell" id="spell-name" placeholder="nome">
                        <input type="text" name="spell-time" id="spell-time" placeholder="casting time" >
                        <input type="text" name="spell-range" id="spell-range" placeholder="range" >
                        <input type="text" name="spell-effect" id="spell-effect" placeholder="efeito" >
                        </div>`
    eightSpell.appendChild(newSpell);
  }

     function adicionarSpellLvl9(){
    const newSpell = document.createElement("div");
    newSpell.innerHTML = `<div class="linha">
                        <input type="text" name="spell" id="spell-name" placeholder="nome">
                        <input type="text" name="spell-time" id="spell-time" placeholder="casting time" >
                        <input type="text" name="spell-range" id="spell-range" placeholder="range" >
                        <input type="text" name="spell-effect" id="spell-effect" placeholder="efeito" >
                        </div>`
    nineSpell.appendChild(newSpell);
  }

  botaoCombat.addEventListener('click', () => {
    navCombat.style.display = "initial";
    navSpell.style.display = "none";
    navInv.style.display = "none";
  })

  botaoSpell.addEventListener('click', () => {
    navSpell.style.display = "initial";
    navCombat.style.display = "none";
    navInv.style.display = "none";
  })

  botaoInv.addEventListener('click', () => {
    navSpell.style.display = "none";
    navCombat.style.display = "none";
    navInv.style.display = "flex";
  })



nivel.addEventListener("change", function(){
  fetch("http://localhost:8080/ficha",
    {
      headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    method: "POST",
    body: JSON.stringify({
      nivel: nivel.value
    })
    }
  ).then(res => res.json())
  .then(data => proficiencia.value = data);
}
)

botao.addEventListener("click", async function(){
  const ficha = await fetch("http://localhost:8080/ficha/criaficha",{
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    method: "POST",
  })
})

botaoDelete.addEventListener("click", async function(){
    fetch("http://localhost:8080/ficha/deletarFichas",
      {
        headers:
        {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    method: 'POST'
      }
    )
})

botaoFicha.addEventListener("click", async function(){
 const response = await fetch("http://localhost:8080/ficha", {
    headers:
        {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    method: 'GET'
  });
  const data = await response.json();
  console.log(data)

  //atributos
  dexAtributo.value = `${JSON.stringify(data[0].atributos.destreza)}`
  forcaAtributo.value = `${JSON.stringify(data[0].atributos.forca)}`
  consAtributo.value = `${JSON.stringify(data[0].atributos.constituicao)}`
  carismaAtributo.value = `${JSON.stringify(data[0].atributos.carisma)}`
  sabAtributo.value = `${JSON.stringify(data[0].atributos.sabedoria)}`
  intAtributo.value = `${JSON.stringify(data[0].atributos.inteligencia)}`
  dexMod.value = `${JSON.stringify(data[0].atributos.destrezaMod)}`
  forcaMod.value = `${JSON.stringify(data[0].atributos.forcaMod)}`
  consMod.value = `${JSON.stringify(data[0].atributos.constituicaoMod)}`
  carismaMod.value = `${JSON.stringify(data[0].atributos.carismaMod)}`
  sabMod.value = `${JSON.stringify(data[0].atributos.sabedoriaMod)}`
  intMod.value = `${JSON.stringify(data[0].atributos.inteligenciaMod)}`
  iniciativa.value = `${JSON.stringify(data[0].iniciativa)}`

  //pericias 

  acrobacia.value = dexMod.value;
  arcanismo.value = intMod.value;
  atletismo.value = forcaMod.value;
  atuacao.value = carismaMod.value;
  engancao.value = carismaMod.value
  furtividade.value = carismaMod.value;
  historia.value = intMod.value;
  intimidacao.value = carismaMod.value
  intuicao.value = sabMod.value
  investigacao.value = intMod.value
  lidarAnimais.value = sabMod.value
  medicina.value = intMod.value
  natureza.value = intMod.value
  percepcao.value = sabMod.value
  persuasao.value = carismaMod.value
  prestidigitacao.value = dexMod.value
  religiao.value = intMod.value
  sobrevivencia.value = sabMod.value


})


forcaAtributo.addEventListener("change", function(){
  fetch("http://localhost:8080/ficha/altera-valor", {
      headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    method: "POST",
    body: JSON.stringify({
      nome: forcaAtributo.id,
      valor: forcaAtributo.value
      
    })
    
    }
  ).then(res => res.json())
  .then(data => forcaAtributo.value = data);
  
}
)
