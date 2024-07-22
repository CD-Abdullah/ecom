var Product= Backbone.Model.extend({
    defaults:{
        name:"",
        description:"",
        brand:"",
        price: 0
    }
   
});
var Products = Backbone.Collection.extend({
    model: Product,
    url: "http://localhost:8080/api/products"
});

var products = new Products();

var columns=[{
    name: "name",
    label: "Product Name",
    cell: "string"
},{
    name: "description",
    label: "Description",
    cell: "string"
},{
    name: "brand",
    label: "Brand",
    cell: "string"
},{
    name: "price",
    label: "Price",
    cell: "integer"
}]

var grid = new Backgrid.Grid({
    columns:columns,
    collection:products
})


grid.render().sort("name","ascending");
$("#grid").append(grid.render().el);

products.fetch();
