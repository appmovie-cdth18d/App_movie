<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateDanhSachVesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('danhsachve', function (Blueprint $table) {
            $table->increments('id');
            $table->integer('Soluong')->unsigned()->default(0);
            $table->double('Tongtien')->default(0);
            $table->integer('taikhoan_id')->unsigned()->index();
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('taikhoan_id')->references('id')->on('taikhoan');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('danhsachve');
    }
}
