export function ajouter (data){
var data2={
    event:data.event,
    date:new Date(),
    session:data.session
}
fetch("http://localhost:8080/api/Journal/ajouter", {
        method: 'POST',
        headers: new Headers({
            'Content-Type': 'application/json','Authorization': 'bearer '+data.token 
        }),
        body: JSON.stringify(data2)
    })

}