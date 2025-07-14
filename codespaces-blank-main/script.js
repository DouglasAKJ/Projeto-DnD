//token
const token = sessionStorage.getItem("auth-token")

//id
const id = sessionStorage.getItem("id-ficha")

//misc
const botao = document.getElementById("botao");
const content = document.getElementById("content");
const body = document.getElementsByTagName("body");

//inputs
const inputAtributo = document.getElementsByName("atributo");
const nomeChar = document.getElementById("nomeChar")
const classe = document.getElementById("classe")
const classeArmadura = document.getElementById("ca")
const deslocamento = document.getElementById("deslocamento")

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

//salva guardas

const forcaSave = document.getElementById("forcaSave");
const consSave = document.getElementById("consSave");
const dexSave = document.getElementById("dexSave");
const intSave = document.getElementById("intSave");
const sabSave = document.getElementById("sabSave");
const carismaSave = document.getElementById("carismaSave");

//check prof salva guarda
const forcaCheck = document.getElementById("forcaCheck")
const dexCheck = document.getElementById("dexCheck")
const consCheck = document.getElementById("consCheck")
const intCheck = document.getElementById("intCheck")
const sabCheck = document.getElementById("sabCheck")
const carCheck = document.getElementById("carCheck")  

//hp
const hpAtual = document.getElementById("hpAtual") 
const hpMax = document.getElementById("hpMax")

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

forcaCheck.addEventListener("change", async function(){
  if(this.checked){
    const response = await fetch(`http://localhost:8080/ficha/profForca/${id}`, {
      headers:{
      'Authorization': `Bearer ${token}`, 
      'Accept': 'application/json',
      'Content-Type': 'application/json'
      },
      method: 'PATCH',
      body: JSON.stringify({
        atributos: {
          forcaProf: true
        }
      })
    })
    const data = await response.json();
    forcaSave.value = data.atributos.forcaSave;
  } else {
    const response = await fetch(`http://localhost:8080/ficha/profForca/${id}`, {
      headers:{
      'Authorization': `Bearer ${token}`, 
      'Accept': 'application/json',
      'Content-Type': 'application/json'
      },
      method: 'PATCH',
      body: JSON.stringify({
        atributos: {
          forcaProf: false
        }
      })
    })

    const data = await response.json() 
    forcaSave.value = data.atributos.forcaSave
  }
})

dexCheck.addEventListener("change", async function(){
  if(this.checked){
    const response = await fetch(`http://localhost:8080/ficha/profDestreza/${id}`, {
      headers:{
      'Authorization': `Bearer ${token}`, 
      'Accept': 'application/json',
      'Content-Type': 'application/json'
      },
      method: 'PATCH',
      body: JSON.stringify({
        atributos: {
          destrezaProf: true
        }
      })
    })
    const data = await response.json();
    dexSave.value = data.atributos.destrezaSave;
  } else {
    const response = await fetch(`http://localhost:8080/ficha/profDestreza/${id}`, {
      headers:{
      'Authorization': `Bearer ${token}`, 
      'Accept': 'application/json',
      'Content-Type': 'application/json'
      },
      method: 'PATCH',
      body: JSON.stringify({
        atributos: {
          destrezaProf: false
        }
      })
    })

    const data = await response.json() 
    dexSave.value = data.atributos.destrezaSave
  }
})

intCheck.addEventListener("change", async function(){
  if(this.checked){
    const response = await fetch(`http://localhost:8080/ficha/profInteligencia/${id}`, {
      headers:{
      'Authorization': `Bearer ${token}`, 
      'Accept': 'application/json',
      'Content-Type': 'application/json'
      },
      method: 'PATCH',
      body: JSON.stringify({
        atributos: {
          inteligenciaProf: true
        }
      })
    })
    const data = await response.json();
    intSave.value = data.atributos.inteligenciaSave;
  } else {
    const response = await fetch(`http://localhost:8080/ficha/profInteligencia/${id}`, {
      headers:{
      'Authorization': `Bearer ${token}`, 
      'Accept': 'application/json',
      'Content-Type': 'application/json'
      },
      method: 'PATCH',
      body: JSON.stringify({
        atributos: {
          inteligenciaProf: false
        }
      })
    })

    const data = await response.json() 
    intSave.value = data.atributos.inteligenciaSave
  }
})

consCheck.addEventListener("change", async function(){
  if(this.checked){
    const response = await fetch(`http://localhost:8080/ficha/profCons/${id}`, {
      headers:{
      'Authorization': `Bearer ${token}`, 
      'Accept': 'application/json',
      'Content-Type': 'application/json'
      },
      method: 'PATCH',
      body: JSON.stringify({
        atributos: {
          constituicaoProf: true
        }
      })
    })
    const data = await response.json();
    consSave.value = data.atributos.constituicaoSave;
  } else {
    const response = await fetch(`http://localhost:8080/ficha/profCons/${id}`, {
      headers:{
      'Authorization': `Bearer ${token}`, 
      'Accept': 'application/json',
      'Content-Type': 'application/json'
      },
      method: 'PATCH',
      body: JSON.stringify({
        atributos: {
          constituicaoProf: false
        }
      })
    })

    const data = await response.json() 
    consSave.value = data.atributos.constituicaoSave
  }
})

sabCheck.addEventListener("change", async function(){
  if(this.checked){
    const response = await fetch(`http://localhost:8080/ficha/profSabedoria/${id}`, {
      headers:{
      'Authorization': `Bearer ${token}`, 
      'Accept': 'application/json',
      'Content-Type': 'application/json'
      },
      method: 'PATCH',
      body: JSON.stringify({
        atributos: {
          sabedoriaProf: true
        }
      })
    })
    const data = await response.json();
    sabSave.value = data.atributos.sabedoriaSave;
  } else {
    const response = await fetch(`http://localhost:8080/ficha/profSabedoria/${id}`, {
      headers:{
      'Authorization': `Bearer ${token}`, 
      'Accept': 'application/json',
      'Content-Type': 'application/json'
      },
      method: 'PATCH',
      body: JSON.stringify({
        atributos: {
          sabedoriaProf: false
        }
      })
    })

    const data = await response.json() 
    sabSave.value = data.atributos.sabedoriaSave
  }
})

carCheck.addEventListener("change", async function(){
  if(this.checked){
    const response = await fetch(`http://localhost:8080/ficha/profCarisma/${id}`, {
      headers:{
      'Authorization': `Bearer ${token}`, 
      'Accept': 'application/json',
      'Content-Type': 'application/json'
      },
      method: 'PATCH',
      body: JSON.stringify({
        atributos: {
          carismaProf: true
        }
      })
    })
    const data = await response.json();
    carismaSave.value = data.atributos.carismaSave;
  } else {
    const response = await fetch(`http://localhost:8080/ficha/profCarisma/${id}`, {
      headers:{
      'Authorization': `Bearer ${token}`, 
      'Accept': 'application/json',
      'Content-Type': 'application/json'
      },
      method: 'PATCH',
      body: JSON.stringify({
        atributos: {
          carismaProf: false
        }
      })
    })

    const data = await response.json() 
    carismaSave.value = data.atributos.carismaSave
  }
})

classe.addEventListener("change", async function(){
  fetch(`http://localhost:8080/ficha/${id}`,
    {
      headers:
      {
      'Authorization': `Bearer ${token}`,
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    method: "POST",
    body: JSON.stringify({
      classe: classe.value
    })
    }
  ).then(res => res.json())
  .then(data => classe.value = data.classe)
})

nomeChar.addEventListener("change", async function(){
  fetch(`http://localhost:8080/ficha/${id}`,
    {
      headers:
      {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    method: "POST",
    body: JSON.stringify({
      nome: nomeChar.value
    })
    }
  ).then(res => res.json())
  .then(data => nomeChar.value = data.nome)
})

classeArmadura.addEventListener("change", async function(){
  fetch(`http://localhost:8080/ficha/${id}`,
    {
      headers:
      {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    method: "POST",
    body: JSON.stringify({
      classeArmadura: classeArmadura.value
    })
    }
  ).then(res => res.json())
  .then(data => classeArmadura.value = data.classeArmadura)
})

deslocamento.addEventListener("change", async function(){
  fetch(`http://localhost:8080/ficha/${id}`,
    {
      headers:
      {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    method: "POST",
    body: JSON.stringify({
      deslocamento: deslocamento.value
    })
    }
  ).then(res => res.json())
  .then(data => deslocamento.value = data.deslocamento)
})

nivel.addEventListener("change", async function(){
  const response = await fetch(`http://localhost:8080/ficha/${id}`,
    {
      headers: {
      'Authorization': `Bearer ${token}`,
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    method: "POST",
    body: JSON.stringify({
      level: nivel.value
    })
    }
  )

  if(response.ok){
    const data = await response.json()
    proficiencia.value = data.proficiencia;
  forcaSave.value = data.atributos.forcaSave
  consSave.value = data.atributos.constituicaoSave
  dexSave.value = data.atributos.destrezaSave
  intSave.value = data.atributos.inteligenciaSave
  sabSave.value = data.atributos.sabedoriaSave
  carismaSave.value = data.atributos.carismaSave
  }
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

hpAtual.addEventListener("change", async function(){
  fetch(`http://localhost:8080/ficha/${id}`, {
    headers:
        {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    method: 'POST',
    body: JSON.stringify({
      vida: hpAtual.value
    })
  }).then(res => res.json)
})

document.addEventListener("DOMContentLoaded", async function(){
 const response = await fetch(`http://localhost:8080/ficha/${id}`, {
    headers:
        {
      'Authorization': `Bearer ${token}`,
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    method: 'GET'
  })

  data = await response.json(); 

  nomeChar.value = `${JSON.stringify(data.nome)}`
  classe.value = `${JSON.stringify(data.classe)}`
  
  //atributos
  dexAtributo.value = `${JSON.stringify(data.atributos.destreza)}`
  forcaAtributo.value = `${JSON.stringify(data.atributos.forca)}`
  consAtributo.value = `${JSON.stringify(data.atributos.constituicao)}`
  carismaAtributo.value = `${JSON.stringify(data.atributos.carisma)}`
  sabAtributo.value = `${JSON.stringify(data.atributos.sabedoria)}`
  intAtributo.value = `${JSON.stringify(data.atributos.inteligencia)}`
  dexMod.value = `${JSON.stringify(data.atributos.destrezaMod)}`
  forcaMod.value = `${JSON.stringify(data.atributos.forcaMod)}`
  consMod.value = `${JSON.stringify(data.atributos.constituicaoMod)}`
  carismaMod.value = `${JSON.stringify(data.atributos.carismaMod)}`
  sabMod.value = `${JSON.stringify(data.atributos.sabedoriaMod)}`
  intMod.value = `${JSON.stringify(data.atributos.inteligenciaMod)}`
  iniciativa.value = `${JSON.stringify(data.iniciativa)}`

  //pericias 

  acrobacia.value = `${JSON.stringify(data.pericias.find(p => p.nome === "Acrobacia").valor)}`
  arcanismo.value = `${JSON.stringify(data.pericias.find(p => p.nome === "Arcanismo").valor)}`
  atletismo.value = `${JSON.stringify(data.pericias.find(p => p.nome === "Atletismo").valor)}`
  atuacao.value = `${JSON.stringify(data.pericias.find(p => p.nome === "Atuação").valor)}`
  engancao.value = `${JSON.stringify(data.pericias.find(p => p.nome === "Enganação").valor)}`
  furtividade.value = `${JSON.stringify(data.pericias.find(p => p.nome === "Furtividade").valor)}`
  historia.value = `${JSON.stringify(data.pericias.find(p => p.nome === "História").valor)}`
  intimidacao.value = `${JSON.stringify(data.pericias.find(p => p.nome === "Intimidação").valor)}`
  intuicao.value = `${JSON.stringify(data.pericias.find(p => p.nome === "Intuição").valor)}`
  investigacao.value = `${JSON.stringify(data.pericias.find(p => p.nome === "Investigação").valor)}`
  lidarAnimais.value = `${JSON.stringify(data.pericias.find(p => p.nome === "Lidar com Animais").valor)}`
  medicina.value = `${JSON.stringify(data.pericias.find(p => p.nome === "Medicina").valor)}`
  natureza.value = `${JSON.stringify(data.pericias.find(p => p.nome === "Natureza").valor)}`
  percepcao.value = `${JSON.stringify(data.pericias.find(p => p.nome === "Percepção").valor)}`
  persuasao.value = `${JSON.stringify(data.pericias.find(p => p.nome === "Persuasão").valor)}`
  prestidigitacao.value = `${JSON.stringify(data.pericias.find(p => p.nome === "Prestidigição").valor)}`
  religiao.value = `${JSON.stringify(data.pericias.find(p => p.nome === "Religião").valor)}`
  sobrevivencia.value = `${JSON.stringify(data.pericias.find(p => p.nome === "Sobrevivência").valor)}`

  //salva guardas
  forcaSave.value = data.atributos.forcaSave
  consSave.value = data.atributos.constituicaoSave
  dexSave.value = data.atributos.destrezaSave
  intSave.value = data.atributos.inteligenciaSave
  sabSave.value = data.atributos.sabedoriaSave
  carismaSave.value = data.atributos.carismaSave

  //prof salva guarda
  forcaCheck.checked = data.atributos.forcaProf ? true : false;
  dexCheck.checked = data.atributos.destrezaProf ? true : false;
  intCheck.checked = data.atributos.inteligenciaProf ? true : false;
  consCheck.checked = data.atributos.constituicaoProf ? true : false;
  sabCheck.checked = data.atributos.sabedoriaProf ? true : false;
  carCheck.checked = data.atributos.carismaProf ? true : false;

  //HP
  hpAtual.value = `${JSON.stringify(data.vida)}`
  
  //Nivel e proficiencia
  nivel.value = `${JSON.stringify(data.level)}`
  proficiencia.value = `${JSON.stringify(data.proficiencia)}`

})


forcaAtributo.addEventListener("change", async function(){
  const response = await fetch(`http://localhost:8080/ficha/alteraForca/${id}`, {
      headers: {
      'Authorization': `Bearer ${token}`,
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    method: "PATCH",
    body: JSON.stringify({
      atributos: {
        forca: Number(forcaAtributo.value)
      }
    })
    
    }
  )

    const data = await response.json();
  forcaAtributo.value = data.atributos.forca;
  forcaMod.value = data.atributos.forcaMod
  atletismo.value = data.pericias.find(p => p.nome === "Atletismo").valor
  forcaSave.value = forcaMod.value
  
}
)

dexAtributo.addEventListener("change", async function(){
  const response = await fetch(`http://localhost:8080/ficha/alteraDex/${id}`, {
      headers: {
        'Authorization': `Bearer ${token}`,
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    method: "PATCH",
    body: JSON.stringify({
      atributos: {
        destreza: Number(dexAtributo.value)
      }
    })
    
    }
  )
  
  const data = await response.json();
  iniciativa.value = data.atributos.destrezaMod
  dexAtributo.value = data.atributos.destreza;
  dexMod.value = data.atributos.destrezaMod
  acrobacia.value = data.pericias.find(p => p.nome === "Acrobacia").valor
  furtividade.value = data.pericias.find(p => p.nome === "Furtividade").valor
  prestidigitacao.value = data.pericias.find(p => p.nome === "Prestidigição").valor
  dexSave.value = destrezaMod.value
  
}
)

consAtributo.addEventListener("change", async function(){
 const response = await fetch(`http://localhost:8080/ficha/alteraCons/${id}`, {
      headers: {
        'Authorization': `Bearer ${token}`,
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    method: "PATCH",
    body: JSON.stringify({
      atributos: {
        constituicao: Number(consAtributo.value)
      }
    })
    
    }
  )

  const data = await response.json();
  consAtributo.value = data.atributos.constituicao;
  consMod.value = data.atributos.constituicaoMod
  consSave.value = constituicaoMod.value
  
}
)

intAtributo.addEventListener("change", async function(){
  const response = await fetch(`http://localhost:8080/ficha/alteraInteligencia/${id}`, {
      headers: {
        'Authorization': `Bearer ${token}`,
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    method: "PATCH",
    body: JSON.stringify({
      atributos: {
        inteligencia: Number(intAtributo.value)
      }
    })
    
    }
  )

    const data = await response.json();
  intAtributo.value = data.atributos.inteligencia;
  intMod.value = data.atributos.inteligenciaMod
  intSave.value = inteligenciaMod.value
  arcanismo.value =  data.pericias.find(p => p.nome === "Arcanismo").valor
  historia.value =  data.pericias.find(p => p.nome === "História").valor
  investigacao.value =  data.pericias.find(p => p.nome === "Investigação").valor
  natureza.value =  data.pericias.find(p => p.nome === "Natureza").valor
  religiao.value =  data.pericias.find(p => p.nome === "Religião").valor
  
}
)

sabAtributo.addEventListener("change", async function(){
 const response = await fetch(`http://localhost:8080/ficha/alteraSab/${id}`, {
      headers: {
        'Authorization': `Bearer ${token}`,
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    method: "PATCH",
    body: JSON.stringify({
      atributos: {
        sabedoria: Number(sabAtributo.value)
      }
    })
    
    }
  )
      const data = await response.json();
  sabAtributo.value = data.atributos.sabedoria;
  sabMod.value = data.atributos.sabedoriaMod
  sabSave.value = sabedoriaMod.value
  intuicao.value =  data.pericias.find(p => p.nome === "Intuição").valor
  lidarAnimais.value =  data.pericias.find(p => p.nome === "Lidar com Animais").valor
  medicina.value =  data.pericias.find(p => p.nome === "Medicina").valor
  percepcao.value =  data.pericias.find(p => p.nome === "Percepção").valor
  sobrevivencia.value =  data.pericias.find(p => p.nome === "Sobrevivência").valor
  
}
)

carismaAtributo.addEventListener("change", async function(){
 const response = await fetch(`http://localhost:8080/ficha/alteraCarisma/${id}`, {
      headers: {
        'Authorization': `Bearer ${token}`,
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    method: "PATCH",
    body: JSON.stringify({
      atributos: {
        carisma: Number(carismaAtributo.value)
      }
    })
    
    }
  )
      const data = await response.json();
  carismaAtributo.value = data.atributos.carisma;
  carismaMod.value = data.atributos.carismaMod
  carismaSave.value = carismaMod.value
  atuacao.value =  data.pericias.find(p => p.nome === "Arcanismo").valor
  engancao.value =  data.pericias.find(p => p.nome === "Enganação").valor
  intimidacao.value =  data.pericias.find(p => p.nome === "Intimidação").valor
  persuasao.value =  data.pericias.find(p => p.nome === "Persuasão").valor
  persuasao.value =  data.pericias.find(p => p.nome === "Persuasão").valor

  
}
)
