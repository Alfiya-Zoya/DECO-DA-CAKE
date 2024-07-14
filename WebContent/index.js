const firebaseConfig = {
    apiKey: "AIzaSyD3XwE9cDb8ucIaeQeb_LucKgw_BGxmY3w",
    authDomain: "uploaddeco.firebaseapp.com",
    projectId: "uploaddeco",
    storageBucket: "uploaddeco.appspot.com",
    messagingSenderId: "38788199269",
    appId: "1:38788199269:web:9388970ca1d1fdc50be78c",
    measurementId: "G-JG2VPT46GD"
  };

  firebase.initializeApp(firebaseConfig);





  var fileText = document.querySelector(".fileText");
var uploadPercentage = document.querySelector(".uploadPercentage");
var progress =document.querySelector(".progress"); 
var percentVal
var fileItem;
var fileName;
var img =document.querySelector(".img");
function getFile(e){
    fileItem =e.target.files[0];
    fileName =fileItem.name; 
    fileText.innerHTML= fileName;
}

function uploadImage(){
let storageRef=firebase.storage().ref("images/"+fileName);
let uploadTask=storageRef.put(fileItem);


uploadTask.on("state_changed",(snapshot)=>{
    console.log(snapshot);
    percentVal=Math.floor((snapshot.bytesTransferred/snapshot.totalBytes)*100);
    console.log(percentVal);
    uploadPercentage.innerHTML=percentVal+"%";
    progress.style.width=percentVal+"%";
},(error)=>{

    console.log("Error is ",error);
},()=>{

    uploadTask.snapshot.ref.getDownloadURL().then((url)=>{
        console.log("URL",url);

        if(url !=""){
            img.setAttribute("src",url);
            img.style.display="block";
        }
    })

}
)
}