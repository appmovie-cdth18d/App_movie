<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateDinhDangPhimsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('DinhDangPhim', function (Blueprint $table) {
            $table->increments('id');
            $table->string('Loaidinhdang');
            $table->integer('Gia_id')->unsigned()->index();
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('Gia_id')->references('id')->on('gia');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('dinh_dang_phims');
    }
}
